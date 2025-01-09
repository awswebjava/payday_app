package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadesloaddvcombo extends GXProcedure
{
   public novedadesloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadesloaddvcombo.class ), "" );
   }

   public novedadesloaddvcombo( int remoteHandle ,
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
      novedadesloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
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
      novedadesloaddvcombo.this.AV17ComboName = aP0;
      novedadesloaddvcombo.this.AV19TrnMode = aP1;
      novedadesloaddvcombo.this.AV24CliCod = aP2;
      novedadesloaddvcombo.this.AV25EmpCod = aP3;
      novedadesloaddvcombo.this.AV26LegNumero = aP4;
      novedadesloaddvcombo.this.AV27AgeOrden = aP5;
      novedadesloaddvcombo.this.aP6 = aP6;
      novedadesloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV24CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      novedadesloaddvcombo.this.GXt_int1 = GXv_int2[0] ;
      AV24CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades", GXv_boolean4) ;
      novedadesloaddvcombo.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
         if ( GXutil.strcmp(AV17ComboName, "ConCodigo") == 0 )
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&TrnMode ", "")+AV19TrnMode) ;
      if ( GXutil.strcmp(AV19TrnMode, "INS") == 0 )
      {
         GXv_char6[0] = AV16SelectedValue ;
         GXv_char7[0] = AV21SelectedText ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV17ComboName, GXv_char6, GXv_char7) ;
         novedadesloaddvcombo.this.AV16SelectedValue = GXv_char6[0] ;
         novedadesloaddvcombo.this.AV21SelectedText = GXv_char7[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&ComboName ", "")+AV17ComboName+httpContext.getMessage( "&SelectedValue ", "")+AV16SelectedValue+httpContext.getMessage( " &SelectedText ", "")+AV21SelectedText) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_CONCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P001S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV24CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P001S2_A37TipoConCod[0] ;
         A3CliCod = P001S2_A3CliCod[0] ;
         A26ConCodigo = P001S2_A26ConCodigo[0] ;
         A42ConCodYDesc = P001S2_A42ConCodYDesc[0] ;
         n42ConCodYDesc = P001S2_n42ConCodYDesc[0] ;
         AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV14Combo_Data.add(AV15Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
      {
         /* Using cursor P001S3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV24CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV26LegNumero), Short.valueOf(AV27AgeOrden)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A25AgeOrden = P001S3_A25AgeOrden[0] ;
            A6LegNumero = P001S3_A6LegNumero[0] ;
            A1EmpCod = P001S3_A1EmpCod[0] ;
            A3CliCod = P001S3_A3CliCod[0] ;
            A26ConCodigo = P001S3_A26ConCodigo[0] ;
            AV16SelectedValue = A26ConCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_LEGNUMERO' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&Cond_CliCod ", "")+GXutil.trim( GXutil.str( AV28Cond_CliCod, 6, 0))+httpContext.getMessage( " &Cond_EmpCod ", "")+GXutil.trim( GXutil.str( AV29Cond_EmpCod, 4, 0))) ;
   }

   protected void cleanup( )
   {
      this.aP6[0] = novedadesloaddvcombo.this.AV16SelectedValue;
      this.aP7[0] = novedadesloaddvcombo.this.AV14Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      GXv_int2 = new int[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Pgmname = "" ;
      GXv_char6 = new String[1] ;
      AV21SelectedText = "" ;
      GXv_char7 = new String[1] ;
      scmdbuf = "" ;
      P001S2_A37TipoConCod = new String[] {""} ;
      P001S2_A3CliCod = new int[1] ;
      P001S2_A26ConCodigo = new String[] {""} ;
      P001S2_A42ConCodYDesc = new String[] {""} ;
      P001S2_n42ConCodYDesc = new boolean[] {false} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P001S3_A25AgeOrden = new short[1] ;
      P001S3_A6LegNumero = new int[1] ;
      P001S3_A1EmpCod = new short[1] ;
      P001S3_A3CliCod = new int[1] ;
      P001S3_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadesloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P001S2_A37TipoConCod, P001S2_A3CliCod, P001S2_A26ConCodigo, P001S2_A42ConCodYDesc, P001S2_n42ConCodYDesc
            }
            , new Object[] {
            P001S3_A25AgeOrden, P001S3_A6LegNumero, P001S3_A1EmpCod, P001S3_A3CliCod, P001S3_A26ConCodigo
            }
         }
      );
      AV32Pgmname = "NovedadesLoadDVCombo" ;
      /* GeneXus formulas. */
      AV32Pgmname = "NovedadesLoadDVCombo" ;
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short AV27AgeOrden ;
   private short A25AgeOrden ;
   private short A1EmpCod ;
   private short AV29Cond_EmpCod ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV26LegNumero ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV28Cond_CliCod ;
   private String AV19TrnMode ;
   private String AV32Pgmname ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private String AV17ComboName ;
   private String AV16SelectedValue ;
   private String AV21SelectedText ;
   private String A42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P001S2_A37TipoConCod ;
   private int[] P001S2_A3CliCod ;
   private String[] P001S2_A26ConCodigo ;
   private String[] P001S2_A42ConCodYDesc ;
   private boolean[] P001S2_n42ConCodYDesc ;
   private short[] P001S3_A25AgeOrden ;
   private int[] P001S3_A6LegNumero ;
   private short[] P001S3_A1EmpCod ;
   private int[] P001S3_A3CliCod ;
   private String[] P001S3_A26ConCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class novedadesloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001S2", "SELECT TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ?) AND (TipoConCod <> ( 'CAL_ARG')) ORDER BY CliCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001S3", "SELECT AgeOrden, LegNumero, EmpCod, CliCod, ConCodigo FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and AgeOrden = ? ORDER BY CliCod, EmpCod, LegNumero, AgeOrden ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

