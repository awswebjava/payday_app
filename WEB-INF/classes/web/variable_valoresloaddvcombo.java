package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variable_valoresloaddvcombo extends GXProcedure
{
   public variable_valoresloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_valoresloaddvcombo.class ), "" );
   }

   public variable_valoresloaddvcombo( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      variable_valoresloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        int aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      variable_valoresloaddvcombo.this.AV15ComboName = aP0;
      variable_valoresloaddvcombo.this.AV16TrnMode = aP1;
      variable_valoresloaddvcombo.this.AV17IsDynamicCall = aP2;
      variable_valoresloaddvcombo.this.AV18CliCod = aP3;
      variable_valoresloaddvcombo.this.AV19OpeCliId = aP4;
      variable_valoresloaddvcombo.this.AV20OpeCliVig = aP5;
      variable_valoresloaddvcombo.this.AV27Cond_CliCod = aP6;
      variable_valoresloaddvcombo.this.AV12SearchTxt = aP7;
      variable_valoresloaddvcombo.this.aP8 = aP8;
      variable_valoresloaddvcombo.this.aP9 = aP9;
      variable_valoresloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores", GXv_boolean2) ;
      variable_valoresloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "OpeCliId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_OPECLIID' */
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
      /* 'LOADCOMBOITEMS_OPECLIID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A549OpeCliCodFormula ,
                                              Integer.valueOf(AV27Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01072 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV27Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A549OpeCliCodFormula = P01072_A549OpeCliCodFormula[0] ;
            A3CliCod = P01072_A3CliCod[0] ;
            A82OpeCliId = P01072_A82OpeCliId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A82OpeCliId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A549OpeCliCodFormula );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01073 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19OpeCliId, AV20OpeCliVig});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A754OpeCliVig = P01073_A754OpeCliVig[0] ;
               A82OpeCliId = P01073_A82OpeCliId[0] ;
               A3CliCod = P01073_A3CliCod[0] ;
               A549OpeCliCodFormula = P01073_A549OpeCliCodFormula[0] ;
               A549OpeCliCodFormula = P01073_A549OpeCliCodFormula[0] ;
               AV21SelectedValue = A82OpeCliId ;
               AV22SelectedText = A549OpeCliCodFormula ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV19OpeCliId)==0) )
            {
               AV21SelectedValue = AV19OpeCliId ;
               /* Using cursor P01074 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV27Cond_CliCod), AV19OpeCliId});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01074_A3CliCod[0] ;
                  A82OpeCliId = P01074_A82OpeCliId[0] ;
                  A549OpeCliCodFormula = P01074_A549OpeCliCodFormula[0] ;
                  AV22SelectedText = A549OpeCliCodFormula ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = variable_valoresloaddvcombo.this.AV21SelectedValue;
      this.aP9[0] = variable_valoresloaddvcombo.this.AV22SelectedText;
      this.aP10[0] = variable_valoresloaddvcombo.this.AV23Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV23Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A549OpeCliCodFormula = "" ;
      P01072_A549OpeCliCodFormula = new String[] {""} ;
      P01072_A3CliCod = new int[1] ;
      P01072_A82OpeCliId = new String[] {""} ;
      A82OpeCliId = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01073_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01073_A82OpeCliId = new String[] {""} ;
      P01073_A3CliCod = new int[1] ;
      P01073_A549OpeCliCodFormula = new String[] {""} ;
      A754OpeCliVig = GXutil.nullDate() ;
      P01074_A3CliCod = new int[1] ;
      P01074_A82OpeCliId = new String[] {""} ;
      P01074_A549OpeCliCodFormula = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_valoresloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01072_A549OpeCliCodFormula, P01072_A3CliCod, P01072_A82OpeCliId
            }
            , new Object[] {
            P01073_A754OpeCliVig, P01073_A82OpeCliId, P01073_A3CliCod, P01073_A549OpeCliCodFormula
            }
            , new Object[] {
            P01074_A3CliCod, P01074_A82OpeCliId, P01074_A549OpeCliCodFormula
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV27Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19OpeCliId ;
   private String scmdbuf ;
   private String A549OpeCliCodFormula ;
   private String A82OpeCliId ;
   private java.util.Date AV20OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV23Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01072_A549OpeCliCodFormula ;
   private int[] P01072_A3CliCod ;
   private String[] P01072_A82OpeCliId ;
   private java.util.Date[] P01073_A754OpeCliVig ;
   private String[] P01073_A82OpeCliId ;
   private int[] P01073_A3CliCod ;
   private String[] P01073_A549OpeCliCodFormula ;
   private int[] P01074_A3CliCod ;
   private String[] P01074_A82OpeCliId ;
   private String[] P01074_A549OpeCliCodFormula ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class variable_valoresloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01072( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A549OpeCliCodFormula ,
                                          int AV27Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT OpeCliCodFormula, CliCod, OpeCliId FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliCodFormula" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01072(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01072", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01073", "SELECT T1.OpeCliVig, T1.OpeCliId, T1.CliCod, T2.OpeCliCodFormula FROM (variable_valores T1 INNER JOIN Variable T2 ON T2.CliCod = T1.CliCod AND T2.OpeCliId = T1.OpeCliId) WHERE T1.CliCod = ? and T1.OpeCliId = ( ?) and T1.OpeCliVig = ? ORDER BY T1.CliCod, T1.OpeCliId, T1.OpeCliVig ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01074", "SELECT CliCod, OpeCliId, OpeCliCodFormula FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

