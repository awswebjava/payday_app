package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class agendanovedadesloaddvcombo extends GXProcedure
{
   public agendanovedadesloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( agendanovedadesloaddvcombo.class ), "" );
   }

   public agendanovedadesloaddvcombo( int remoteHandle ,
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
      agendanovedadesloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
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
      agendanovedadesloaddvcombo.this.AV16ComboName = aP0;
      agendanovedadesloaddvcombo.this.AV18TrnMode = aP1;
      agendanovedadesloaddvcombo.this.AV24CliCod = aP2;
      agendanovedadesloaddvcombo.this.AV25EmpCod = aP3;
      agendanovedadesloaddvcombo.this.AV26LegNumero = aP4;
      agendanovedadesloaddvcombo.this.AV27AgeOrden = aP5;
      agendanovedadesloaddvcombo.this.aP6 = aP6;
      agendanovedadesloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades", GXv_boolean2) ;
      agendanovedadesloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV16ComboName, "ConCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONCODIGO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( GXutil.strcmp(AV18TrnMode, "INS") == 0 )
      {
         GXv_char4[0] = AV15SelectedValue ;
         GXv_char5[0] = AV20SelectedText ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV16ComboName, GXv_char4, GXv_char5) ;
         agendanovedadesloaddvcombo.this.AV15SelectedValue = GXv_char4[0] ;
         agendanovedadesloaddvcombo.this.AV20SelectedText = GXv_char5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&ComboName ", "")+AV16ComboName+httpContext.getMessage( "&SelectedValue ", "")+AV15SelectedValue+httpContext.getMessage( " &SelectedText ", "")+AV20SelectedText) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_CONCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P000S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV24CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P000S2_A3CliCod[0] ;
         A26ConCodigo = P000S2_A26ConCodigo[0] ;
         A42ConCodYDesc = P000S2_A42ConCodYDesc[0] ;
         n42ConCodYDesc = P000S2_n42ConCodYDesc[0] ;
         AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV13Combo_Data.add(AV14Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV18TrnMode, "INS") != 0 )
      {
         /* Using cursor P000S3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV24CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV26LegNumero), Short.valueOf(AV27AgeOrden)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A25AgeOrden = P000S3_A25AgeOrden[0] ;
            A6LegNumero = P000S3_A6LegNumero[0] ;
            A1EmpCod = P000S3_A1EmpCod[0] ;
            A3CliCod = P000S3_A3CliCod[0] ;
            A26ConCodigo = P000S3_A26ConCodigo[0] ;
            AV15SelectedValue = A26ConCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = agendanovedadesloaddvcombo.this.AV15SelectedValue;
      this.aP7[0] = agendanovedadesloaddvcombo.this.AV13Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15SelectedValue = "" ;
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_char4 = new String[1] ;
      AV20SelectedText = "" ;
      GXv_char5 = new String[1] ;
      AV33Pgmname = "" ;
      scmdbuf = "" ;
      P000S2_A3CliCod = new int[1] ;
      P000S2_A26ConCodigo = new String[] {""} ;
      P000S2_A42ConCodYDesc = new String[] {""} ;
      P000S2_n42ConCodYDesc = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P000S3_A25AgeOrden = new short[1] ;
      P000S3_A6LegNumero = new int[1] ;
      P000S3_A1EmpCod = new short[1] ;
      P000S3_A3CliCod = new int[1] ;
      P000S3_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.agendanovedadesloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P000S2_A3CliCod, P000S2_A26ConCodigo, P000S2_A42ConCodYDesc, P000S2_n42ConCodYDesc
            }
            , new Object[] {
            P000S3_A25AgeOrden, P000S3_A6LegNumero, P000S3_A1EmpCod, P000S3_A3CliCod, P000S3_A26ConCodigo
            }
         }
      );
      AV33Pgmname = "AgendaNovedadesLoadDVCombo" ;
      /* GeneXus formulas. */
      AV33Pgmname = "AgendaNovedadesLoadDVCombo" ;
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short AV27AgeOrden ;
   private short A25AgeOrden ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV26LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV18TrnMode ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String AV33Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private String AV16ComboName ;
   private String AV15SelectedValue ;
   private String AV20SelectedText ;
   private String A42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P000S2_A3CliCod ;
   private String[] P000S2_A26ConCodigo ;
   private String[] P000S2_A42ConCodYDesc ;
   private boolean[] P000S2_n42ConCodYDesc ;
   private short[] P000S3_A25AgeOrden ;
   private int[] P000S3_A6LegNumero ;
   private short[] P000S3_A1EmpCod ;
   private int[] P000S3_A3CliCod ;
   private String[] P000S3_A26ConCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class agendanovedadesloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000S2", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000S3", "SELECT AgeOrden, LegNumero, EmpCod, CliCod, ConCodigo FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and AgeOrden = ? ORDER BY CliCod, EmpCod, LegNumero, AgeOrden ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

