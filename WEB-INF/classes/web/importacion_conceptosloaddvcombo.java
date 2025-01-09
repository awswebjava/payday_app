package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importacion_conceptosloaddvcombo extends GXProcedure
{
   public importacion_conceptosloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_conceptosloaddvcombo.class ), "" );
   }

   public importacion_conceptosloaddvcombo( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> executeUdp( String aP0 ,
                                                                                    String aP1 ,
                                                                                    int aP2 ,
                                                                                    short aP3 ,
                                                                                    short aP4 ,
                                                                                    String aP5 ,
                                                                                    String[] aP6 )
   {
      importacion_conceptosloaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             short aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 )
   {
      importacion_conceptosloaddvcombo.this.AV14ComboName = aP0;
      importacion_conceptosloaddvcombo.this.AV16TrnMode = aP1;
      importacion_conceptosloaddvcombo.this.AV18CliCod = aP2;
      importacion_conceptosloaddvcombo.this.AV19EmpCod = aP3;
      importacion_conceptosloaddvcombo.this.AV20ImpLiqSec = aP4;
      importacion_conceptosloaddvcombo.this.AV21ImpLiqConExtCod = aP5;
      importacion_conceptosloaddvcombo.this.aP6 = aP6;
      importacion_conceptosloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos", GXv_boolean2) ;
      importacion_conceptosloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV14ComboName, "ImpLiqConSisCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_IMPLIQCONSISCOD' */
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
      /* 'LOADCOMBOITEMS_IMPLIQCONSISCOD' Routine */
      returnInSub = false ;
      /* Using cursor P00NZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkNZ2 = false ;
         A3CliCod = P00NZ2_A3CliCod[0] ;
         A370TipoConDescrip = P00NZ2_A370TipoConDescrip[0] ;
         A26ConCodigo = P00NZ2_A26ConCodigo[0] ;
         A42ConCodYDesc = P00NZ2_A42ConCodYDesc[0] ;
         n42ConCodYDesc = P00NZ2_n42ConCodYDesc[0] ;
         A37TipoConCod = P00NZ2_A37TipoConCod[0] ;
         A370TipoConDescrip = P00NZ2_A370TipoConDescrip[0] ;
         AV22ComboCat_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV22ComboCat_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A37TipoConCod );
         AV22ComboCat_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A370TipoConDescrip );
         AV11Combo_Data.add(AV22ComboCat_DataItem, 0);
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00NZ2_A370TipoConDescrip[0], A370TipoConDescrip) == 0 ) )
         {
            brkNZ2 = false ;
            A3CliCod = P00NZ2_A3CliCod[0] ;
            A26ConCodigo = P00NZ2_A26ConCodigo[0] ;
            A42ConCodYDesc = P00NZ2_A42ConCodYDesc[0] ;
            n42ConCodYDesc = P00NZ2_n42ConCodYDesc[0] ;
            A37TipoConCod = P00NZ2_A37TipoConCod[0] ;
            AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
            AV22ComboCat_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV12Combo_DataItem, 0);
            brkNZ2 = true ;
            pr_default.readNext(0);
         }
         if ( ! brkNZ2 )
         {
            brkNZ2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
      {
         /* Using cursor P00NZ3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Short.valueOf(AV20ImpLiqSec), AV21ImpLiqConExtCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A89ImpLiqConExtCod = P00NZ3_A89ImpLiqConExtCod[0] ;
            A88ImpLiqSec = P00NZ3_A88ImpLiqSec[0] ;
            A1EmpCod = P00NZ3_A1EmpCod[0] ;
            A3CliCod = P00NZ3_A3CliCod[0] ;
            A641ImpLiqConSisCod = P00NZ3_A641ImpLiqConSisCod[0] ;
            AV13SelectedValue = A641ImpLiqConSisCod ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = importacion_conceptosloaddvcombo.this.AV13SelectedValue;
      this.aP7[0] = importacion_conceptosloaddvcombo.this.AV11Combo_Data;
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
      scmdbuf = "" ;
      P00NZ2_A3CliCod = new int[1] ;
      P00NZ2_A370TipoConDescrip = new String[] {""} ;
      P00NZ2_A26ConCodigo = new String[] {""} ;
      P00NZ2_A42ConCodYDesc = new String[] {""} ;
      P00NZ2_n42ConCodYDesc = new boolean[] {false} ;
      P00NZ2_A37TipoConCod = new String[] {""} ;
      A370TipoConDescrip = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      A37TipoConCod = "" ;
      AV22ComboCat_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV12Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P00NZ3_A89ImpLiqConExtCod = new String[] {""} ;
      P00NZ3_A88ImpLiqSec = new short[1] ;
      P00NZ3_A1EmpCod = new short[1] ;
      P00NZ3_A3CliCod = new int[1] ;
      P00NZ3_A641ImpLiqConSisCod = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      A641ImpLiqConSisCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_conceptosloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P00NZ2_A3CliCod, P00NZ2_A370TipoConDescrip, P00NZ2_A26ConCodigo, P00NZ2_A42ConCodYDesc, P00NZ2_n42ConCodYDesc, P00NZ2_A37TipoConCod
            }
            , new Object[] {
            P00NZ3_A89ImpLiqConExtCod, P00NZ3_A88ImpLiqSec, P00NZ3_A1EmpCod, P00NZ3_A3CliCod, P00NZ3_A641ImpLiqConSisCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short AV20ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV21ImpLiqConExtCod ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A89ImpLiqConExtCod ;
   private String A641ImpLiqConSisCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkNZ2 ;
   private boolean n42ConCodYDesc ;
   private String AV14ComboName ;
   private String AV13SelectedValue ;
   private String A370TipoConDescrip ;
   private String A42ConCodYDesc ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00NZ2_A3CliCod ;
   private String[] P00NZ2_A370TipoConDescrip ;
   private String[] P00NZ2_A26ConCodigo ;
   private String[] P00NZ2_A42ConCodYDesc ;
   private boolean[] P00NZ2_n42ConCodYDesc ;
   private String[] P00NZ2_A37TipoConCod ;
   private String[] P00NZ3_A89ImpLiqConExtCod ;
   private short[] P00NZ3_A88ImpLiqSec ;
   private short[] P00NZ3_A1EmpCod ;
   private int[] P00NZ3_A3CliCod ;
   private String[] P00NZ3_A641ImpLiqConSisCod ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV11Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV22ComboCat_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV12Combo_DataItem ;
}

final  class importacion_conceptosloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00NZ2", "SELECT T1.CliCod, T2.TipoConDescrip, T1.ConCodigo, T1.ConCodYDesc, T1.TipoConCod FROM (Concepto T1 INNER JOIN TipoDeConcepto T2 ON T2.TipoConCod = T1.TipoConCod) WHERE (T1.TipoConCod <> ( 'CAL_ARG')) AND (T1.CliCod = ?) ORDER BY T2.TipoConDescrip, T1.ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00NZ3", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConSisCod FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

