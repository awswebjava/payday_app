package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajolicenciasloaddvcombo extends GXProcedure
{
   public legajolicenciasloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajolicenciasloaddvcombo.class ), "" );
   }

   public legajolicenciasloaddvcombo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> executeUdp( String aP0 ,
                                                                                    String aP1 ,
                                                                                    int aP2 ,
                                                                                    short aP3 ,
                                                                                    int aP4 ,
                                                                                    java.util.Date aP5 ,
                                                                                    String[] aP6 )
   {
      legajolicenciasloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String[] aP6 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String[] aP6 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      legajolicenciasloaddvcombo.this.AV14ComboName = aP0;
      legajolicenciasloaddvcombo.this.AV16TrnMode = aP1;
      legajolicenciasloaddvcombo.this.AV18CliCod = aP2;
      legajolicenciasloaddvcombo.this.AV19EmpCod = aP3;
      legajolicenciasloaddvcombo.this.AV20LegNumero = aP4;
      legajolicenciasloaddvcombo.this.AV21LegLicenIni = aP5;
      legajolicenciasloaddvcombo.this.aP6 = aP6;
      legajolicenciasloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias", GXv_boolean2) ;
      legajolicenciasloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV14ComboName, "LegLicSitCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGLICSITCODIGO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( GXutil.strcmp(AV16TrnMode, "INS") == 0 )
      {
         GXv_char4[0] = AV13SelectedValue ;
         GXv_char5[0] = "" ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV14ComboName, GXv_char4, GXv_char5) ;
         legajolicenciasloaddvcombo.this.AV13SelectedValue = GXv_char4[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_LEGLICSITCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P001V2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P001V2_A16SitCodigo[0] ;
         A913sItDescAbrev = P001V2_A913sItDescAbrev[0] ;
         AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A16SitCodigo );
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A913sItDescAbrev );
         AV11Combo_Data.add(AV12Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
      {
         /* Using cursor P001V3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV21LegLicenIni});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A76LegLicenIni = P001V3_A76LegLicenIni[0] ;
            A6LegNumero = P001V3_A6LegNumero[0] ;
            A1EmpCod = P001V3_A1EmpCod[0] ;
            A3CliCod = P001V3_A3CliCod[0] ;
            A506LegLicSitCodigo = P001V3_A506LegLicSitCodigo[0] ;
            AV13SelectedValue = A506LegLicSitCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = legajolicenciasloaddvcombo.this.AV13SelectedValue;
      this.aP7[0] = legajolicenciasloaddvcombo.this.AV11Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13SelectedValue = "" ;
      AV11Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      scmdbuf = "" ;
      P001V2_A16SitCodigo = new String[] {""} ;
      P001V2_A913sItDescAbrev = new String[] {""} ;
      A16SitCodigo = "" ;
      A913sItDescAbrev = "" ;
      AV12Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P001V3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P001V3_A6LegNumero = new int[1] ;
      P001V3_A1EmpCod = new short[1] ;
      P001V3_A3CliCod = new int[1] ;
      P001V3_A506LegLicSitCodigo = new String[] {""} ;
      A76LegLicenIni = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajolicenciasloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P001V2_A16SitCodigo, P001V2_A913sItDescAbrev
            }
            , new Object[] {
            P001V3_A76LegLicenIni, P001V3_A6LegNumero, P001V3_A1EmpCod, P001V3_A3CliCod, P001V3_A506LegLicSitCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV21LegLicenIni ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV14ComboName ;
   private String AV13SelectedValue ;
   private String A913sItDescAbrev ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P001V2_A16SitCodigo ;
   private String[] P001V2_A913sItDescAbrev ;
   private java.util.Date[] P001V3_A76LegLicenIni ;
   private int[] P001V3_A6LegNumero ;
   private short[] P001V3_A1EmpCod ;
   private int[] P001V3_A3CliCod ;
   private String[] P001V3_A506LegLicSitCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV11Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV12Combo_DataItem ;
}

final  class legajolicenciasloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001V2", "SELECT SitCodigo, sItDescAbrev FROM Estado ORDER BY sItDescAbrev ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001V3", "SELECT LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegLicenIni = ? ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

