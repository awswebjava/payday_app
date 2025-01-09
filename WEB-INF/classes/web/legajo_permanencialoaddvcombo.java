package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_permanencialoaddvcombo extends GXProcedure
{
   public legajo_permanencialoaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_permanencialoaddvcombo.class ), "" );
   }

   public legajo_permanencialoaddvcombo( int remoteHandle ,
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
      legajo_permanencialoaddvcombo.this.aP7 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
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
      legajo_permanencialoaddvcombo.this.AV15ComboName = aP0;
      legajo_permanencialoaddvcombo.this.AV16TrnMode = aP1;
      legajo_permanencialoaddvcombo.this.AV18CliCod = aP2;
      legajo_permanencialoaddvcombo.this.AV19EmpCod = aP3;
      legajo_permanencialoaddvcombo.this.AV20LegNumero = aP4;
      legajo_permanencialoaddvcombo.this.AV21LegHisFecIng = aP5;
      legajo_permanencialoaddvcombo.this.aP6 = aP6;
      legajo_permanencialoaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia", GXv_boolean2) ;
      legajo_permanencialoaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         if ( GXutil.strcmp(AV15ComboName, "LegNumero") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGNUMERO' */
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
      /* 'LOADCOMBOITEMS_LEGNUMERO' Routine */
      returnInSub = false ;
      /* Using cursor P02942 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02942_A3CliCod[0] ;
         A1EmpCod = P02942_A1EmpCod[0] ;
         A6LegNumero = P02942_A6LegNumero[0] ;
         A250LegIdNomApe = P02942_A250LegIdNomApe[0] ;
         AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV13Combo_Data.add(AV14Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
      {
         /* Using cursor P02943 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV21LegHisFecIng});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2253LegHisFecIng = P02943_A2253LegHisFecIng[0] ;
            A6LegNumero = P02943_A6LegNumero[0] ;
            A1EmpCod = P02943_A1EmpCod[0] ;
            A3CliCod = P02943_A3CliCod[0] ;
            AV22SelectedValue = ((0==A6LegNumero) ? "" : GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      else
      {
         if ( ! (0==AV20LegNumero) )
         {
            AV22SelectedValue = GXutil.trim( GXutil.str( AV20LegNumero, 8, 0)) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = legajo_permanencialoaddvcombo.this.AV22SelectedValue;
      this.aP7[0] = legajo_permanencialoaddvcombo.this.AV13Combo_Data;
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
      P02942_A3CliCod = new int[1] ;
      P02942_A1EmpCod = new short[1] ;
      P02942_A6LegNumero = new int[1] ;
      P02942_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      P02943_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02943_A6LegNumero = new int[1] ;
      P02943_A1EmpCod = new short[1] ;
      P02943_A3CliCod = new int[1] ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_permanencialoaddvcombo__default(),
         new Object[] {
             new Object[] {
            P02942_A3CliCod, P02942_A1EmpCod, P02942_A6LegNumero, P02942_A250LegIdNomApe
            }
            , new Object[] {
            P02943_A2253LegHisFecIng, P02943_A6LegNumero, P02943_A1EmpCod, P02943_A3CliCod
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
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private java.util.Date AV21LegHisFecIng ;
   private java.util.Date A2253LegHisFecIng ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV15ComboName ;
   private String AV22SelectedValue ;
   private String A250LegIdNomApe ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P02942_A3CliCod ;
   private short[] P02942_A1EmpCod ;
   private int[] P02942_A6LegNumero ;
   private String[] P02942_A250LegIdNomApe ;
   private java.util.Date[] P02943_A2253LegHisFecIng ;
   private int[] P02943_A6LegNumero ;
   private short[] P02943_A1EmpCod ;
   private int[] P02943_A3CliCod ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class legajo_permanencialoaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02942", "SELECT CliCod, EmpCod, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY LegIdNomApe ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02943", "SELECT LegHisFecIng, LegNumero, EmpCod, CliCod FROM legajo_permanencia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegHisFecIng = ? ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

