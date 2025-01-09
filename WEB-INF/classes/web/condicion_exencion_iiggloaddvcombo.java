package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicion_exencion_iiggloaddvcombo extends GXProcedure
{
   public condicion_exencion_iiggloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicion_exencion_iiggloaddvcombo.class ), "" );
   }

   public condicion_exencion_iiggloaddvcombo( int remoteHandle ,
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
                             int aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      condicion_exencion_iiggloaddvcombo.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      condicion_exencion_iiggloaddvcombo.this.AV15ComboName = aP0;
      condicion_exencion_iiggloaddvcombo.this.AV16TrnMode = aP1;
      condicion_exencion_iiggloaddvcombo.this.AV17IsDynamicCall = aP2;
      condicion_exencion_iiggloaddvcombo.this.AV18CliCod = aP3;
      condicion_exencion_iiggloaddvcombo.this.AV19CondExenIIGG = aP4;
      condicion_exencion_iiggloaddvcombo.this.AV28Cond_CliCod = aP5;
      condicion_exencion_iiggloaddvcombo.this.AV12SearchTxt = aP6;
      condicion_exencion_iiggloaddvcombo.this.aP7 = aP7;
      condicion_exencion_iiggloaddvcombo.this.aP8 = aP8;
      condicion_exencion_iiggloaddvcombo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg", GXv_boolean2) ;
      condicion_exencion_iiggloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "CondExenIIGGCon") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONDEXENIIGGCON' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "CondExenIIGGVar") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONDEXENIIGGVAR' */
            S121 ();
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
      /* 'LOADCOMBOITEMS_CONDEXENIIGGCON' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A42ConCodYDesc ,
                                              Integer.valueOf(AV28Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P017W2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV28Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A42ConCodYDesc = P017W2_A42ConCodYDesc[0] ;
            n42ConCodYDesc = P017W2_n42ConCodYDesc[0] ;
            A3CliCod = P017W2_A3CliCod[0] ;
            A26ConCodigo = P017W2_A26ConCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P017W3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19CondExenIIGG});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1105CondExenIIGG = P017W3_A1105CondExenIIGG[0] ;
                  A3CliCod = P017W3_A3CliCod[0] ;
                  A1104CondExenIIGGCon = P017W3_A1104CondExenIIGGCon[0] ;
                  AV20SelectedValue = A1104CondExenIIGGCon ;
                  AV27Cond_Aux_CliCod = A3CliCod ;
                  AV30ConCodigo = A1104CondExenIIGGCon ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV30ConCodigo = AV12SearchTxt ;
               AV27Cond_Aux_CliCod = AV28Cond_CliCod ;
            }
            /* Using cursor P017W4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV27Cond_Aux_CliCod), AV30ConCodigo});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A3CliCod = P017W4_A3CliCod[0] ;
               A26ConCodigo = P017W4_A26ConCodigo[0] ;
               A42ConCodYDesc = P017W4_A42ConCodYDesc[0] ;
               n42ConCodYDesc = P017W4_n42ConCodYDesc[0] ;
               AV21SelectedText = A42ConCodYDesc ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_CONDEXENIIGGVAR' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A549OpeCliCodFormula ,
                                              Integer.valueOf(AV28Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P017W5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV28Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A549OpeCliCodFormula = P017W5_A549OpeCliCodFormula[0] ;
            A3CliCod = P017W5_A3CliCod[0] ;
            A82OpeCliId = P017W5_A82OpeCliId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A82OpeCliId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A549OpeCliCodFormula );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P017W6 */
               pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), AV19CondExenIIGG});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A1105CondExenIIGG = P017W6_A1105CondExenIIGG[0] ;
                  A3CliCod = P017W6_A3CliCod[0] ;
                  A1123CondExenIIGGVar = P017W6_A1123CondExenIIGGVar[0] ;
                  n1123CondExenIIGGVar = P017W6_n1123CondExenIIGGVar[0] ;
                  AV20SelectedValue = A1123CondExenIIGGVar ;
                  AV27Cond_Aux_CliCod = A3CliCod ;
                  AV26OpeCliId = A1123CondExenIIGGVar ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV26OpeCliId = AV12SearchTxt ;
               AV27Cond_Aux_CliCod = AV28Cond_CliCod ;
            }
            /* Using cursor P017W7 */
            pr_default.execute(5, new Object[] {Integer.valueOf(AV27Cond_Aux_CliCod), AV26OpeCliId});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A3CliCod = P017W7_A3CliCod[0] ;
               A82OpeCliId = P017W7_A82OpeCliId[0] ;
               A549OpeCliCodFormula = P017W7_A549OpeCliCodFormula[0] ;
               AV21SelectedText = A549OpeCliCodFormula ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = condicion_exencion_iiggloaddvcombo.this.AV20SelectedValue;
      this.aP8[0] = condicion_exencion_iiggloaddvcombo.this.AV21SelectedText;
      this.aP9[0] = condicion_exencion_iiggloaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV22Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A42ConCodYDesc = "" ;
      P017W2_A42ConCodYDesc = new String[] {""} ;
      P017W2_n42ConCodYDesc = new boolean[] {false} ;
      P017W2_A3CliCod = new int[1] ;
      P017W2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P017W3_A1105CondExenIIGG = new String[] {""} ;
      P017W3_A3CliCod = new int[1] ;
      P017W3_A1104CondExenIIGGCon = new String[] {""} ;
      A1105CondExenIIGG = "" ;
      A1104CondExenIIGGCon = "" ;
      AV30ConCodigo = "" ;
      P017W4_A3CliCod = new int[1] ;
      P017W4_A26ConCodigo = new String[] {""} ;
      P017W4_A42ConCodYDesc = new String[] {""} ;
      P017W4_n42ConCodYDesc = new boolean[] {false} ;
      A549OpeCliCodFormula = "" ;
      P017W5_A549OpeCliCodFormula = new String[] {""} ;
      P017W5_A3CliCod = new int[1] ;
      P017W5_A82OpeCliId = new String[] {""} ;
      A82OpeCliId = "" ;
      P017W6_A1105CondExenIIGG = new String[] {""} ;
      P017W6_A3CliCod = new int[1] ;
      P017W6_A1123CondExenIIGGVar = new String[] {""} ;
      P017W6_n1123CondExenIIGGVar = new boolean[] {false} ;
      A1123CondExenIIGGVar = "" ;
      AV26OpeCliId = "" ;
      P017W7_A3CliCod = new int[1] ;
      P017W7_A82OpeCliId = new String[] {""} ;
      P017W7_A549OpeCliCodFormula = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicion_exencion_iiggloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P017W2_A42ConCodYDesc, P017W2_n42ConCodYDesc, P017W2_A3CliCod, P017W2_A26ConCodigo
            }
            , new Object[] {
            P017W3_A1105CondExenIIGG, P017W3_A3CliCod, P017W3_A1104CondExenIIGGCon
            }
            , new Object[] {
            P017W4_A3CliCod, P017W4_A26ConCodigo, P017W4_A42ConCodYDesc, P017W4_n42ConCodYDesc
            }
            , new Object[] {
            P017W5_A549OpeCliCodFormula, P017W5_A3CliCod, P017W5_A82OpeCliId
            }
            , new Object[] {
            P017W6_A1105CondExenIIGG, P017W6_A3CliCod, P017W6_A1123CondExenIIGGVar, P017W6_n1123CondExenIIGGVar
            }
            , new Object[] {
            P017W7_A3CliCod, P017W7_A82OpeCliId, P017W7_A549OpeCliCodFormula
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV28Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int AV27Cond_Aux_CliCod ;
   private String AV16TrnMode ;
   private String AV19CondExenIIGG ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1105CondExenIIGG ;
   private String A1104CondExenIIGGCon ;
   private String AV30ConCodigo ;
   private String A549OpeCliCodFormula ;
   private String A82OpeCliId ;
   private String A1123CondExenIIGGVar ;
   private String AV26OpeCliId ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n42ConCodYDesc ;
   private boolean n1123CondExenIIGGVar ;
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A42ConCodYDesc ;
   private String[] aP9 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P017W2_A42ConCodYDesc ;
   private boolean[] P017W2_n42ConCodYDesc ;
   private int[] P017W2_A3CliCod ;
   private String[] P017W2_A26ConCodigo ;
   private String[] P017W3_A1105CondExenIIGG ;
   private int[] P017W3_A3CliCod ;
   private String[] P017W3_A1104CondExenIIGGCon ;
   private int[] P017W4_A3CliCod ;
   private String[] P017W4_A26ConCodigo ;
   private String[] P017W4_A42ConCodYDesc ;
   private boolean[] P017W4_n42ConCodYDesc ;
   private String[] P017W5_A549OpeCliCodFormula ;
   private int[] P017W5_A3CliCod ;
   private String[] P017W5_A82OpeCliId ;
   private String[] P017W6_A1105CondExenIIGG ;
   private int[] P017W6_A3CliCod ;
   private String[] P017W6_A1123CondExenIIGGVar ;
   private boolean[] P017W6_n1123CondExenIIGGVar ;
   private int[] P017W7_A3CliCod ;
   private String[] P017W7_A82OpeCliId ;
   private String[] P017W7_A549OpeCliCodFormula ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class condicion_exencion_iiggloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P017W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A42ConCodYDesc ,
                                          int AV28Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ConCodYDesc, CliCod, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConCodYDesc) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodYDesc" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P017W5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A549OpeCliCodFormula ,
                                          int AV28Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT OpeCliCodFormula, CliCod, OpeCliId FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliCodFormula" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P017W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 3 :
                  return conditional_P017W5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017W3", "SELECT CondExenIIGG, CliCod, CondExenIIGGCon FROM condicion_exencion_iigg WHERE CliCod = ? and CondExenIIGG = ( ?) ORDER BY CliCod, CondExenIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P017W4", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P017W5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017W6", "SELECT CondExenIIGG, CliCod, CondExenIIGGVar FROM condicion_exencion_iigg WHERE CliCod = ? and CondExenIIGG = ( ?) ORDER BY CliCod, CondExenIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P017W7", "SELECT CliCod, OpeCliId, OpeCliCodFormula FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 5 :
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
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
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

