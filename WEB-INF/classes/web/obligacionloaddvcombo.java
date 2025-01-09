package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obligacionloaddvcombo extends GXProcedure
{
   public obligacionloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacionloaddvcombo.class ), "" );
   }

   public obligacionloaddvcombo( int remoteHandle ,
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
                                                                                    short aP5 ,
                                                                                    String[] aP6 )
   {
      obligacionloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        short aP5 ,
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
                             short aP5 ,
                             String[] aP6 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      obligacionloaddvcombo.this.AV15ComboName = aP0;
      obligacionloaddvcombo.this.AV16TrnMode = aP1;
      obligacionloaddvcombo.this.AV18CliCod = aP2;
      obligacionloaddvcombo.this.AV19EmpCod = aP3;
      obligacionloaddvcombo.this.AV20LegNumero = aP4;
      obligacionloaddvcombo.this.AV21OblSecuencial = aP5;
      obligacionloaddvcombo.this.aP6 = aP6;
      obligacionloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion", GXv_boolean2) ;
      obligacionloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV15ComboName, "OblExcConCOdigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_OBLEXCCONCODIGO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_OBLEXCCONCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P019J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P019J2_A3CliCod[0] ;
         A26ConCodigo = P019J2_A26ConCodigo[0] ;
         A41ConDescrip = P019J2_A41ConDescrip[0] ;
         AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A41ConDescrip );
         AV13Combo_Data.add(AV14Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP6[0] = obligacionloaddvcombo.this.AV22SelectedValue;
      this.aP7[0] = obligacionloaddvcombo.this.AV13Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22SelectedValue = "" ;
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      P019J2_A3CliCod = new int[1] ;
      P019J2_A26ConCodigo = new String[] {""} ;
      P019J2_A41ConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacionloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P019J2_A3CliCod, P019J2_A26ConCodigo, P019J2_A41ConDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short AV21OblSecuencial ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV15ComboName ;
   private String AV22SelectedValue ;
   private String A41ConDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P019J2_A3CliCod ;
   private String[] P019J2_A26ConCodigo ;
   private String[] P019J2_A41ConDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class obligacionloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019J2", "SELECT CliCod, ConCodigo, ConDescrip FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

