package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqimportarauxtrnwwgetfilterdata extends GXProcedure
{
   public liqimportarauxtrnwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqimportarauxtrnwwgetfilterdata.class ), "" );
   }

   public liqimportarauxtrnwwgetfilterdata( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      liqimportarauxtrnwwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      liqimportarauxtrnwwgetfilterdata.this.AV20DDOName = aP0;
      liqimportarauxtrnwwgetfilterdata.this.AV18SearchTxt = aP1;
      liqimportarauxtrnwwgetfilterdata.this.AV19SearchTxtTo = aP2;
      liqimportarauxtrnwwgetfilterdata.this.aP3 = aP3;
      liqimportarauxtrnwwgetfilterdata.this.aP4 = aP4;
      liqimportarauxtrnwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn", GXv_boolean2) ;
      liqimportarauxtrnwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_EMPNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPNOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV24OptionsJson = AV23Options.toJSonString(false) ;
      AV27OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV29OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("LiqImportarAuxTrnWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiqImportarAuxTrnWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("LiqImportarAuxTrnWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCOD") == 0 )
         {
            AV13TFEmpCod = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFEmpCod_To = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM") == 0 )
         {
            AV16TFEmpNom = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM_SEL") == 0 )
         {
            AV15TFEmpNom_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFEmpNom_Sels.fromJSonString(AV15TFEmpNom_SelsJson, null);
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPNOMOPTIONS' Routine */
      returnInSub = false ;
      AV16TFEmpNom = AV18SearchTxt ;
      AV17TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42Liqimportarauxtrnwwds_1_tfclicod = AV11TFCliCod ;
      AV43Liqimportarauxtrnwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV44Liqimportarauxtrnwwds_3_tfempcod = AV13TFEmpCod ;
      AV45Liqimportarauxtrnwwds_4_tfempcod_to = AV14TFEmpCod_To ;
      AV46Liqimportarauxtrnwwds_5_tfempnom = AV16TFEmpNom ;
      AV47Liqimportarauxtrnwwds_6_tfempnom_sels = AV17TFEmpNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV47Liqimportarauxtrnwwds_6_tfempnom_sels ,
                                           Integer.valueOf(AV42Liqimportarauxtrnwwds_1_tfclicod) ,
                                           Integer.valueOf(AV43Liqimportarauxtrnwwds_2_tfclicod_to) ,
                                           Short.valueOf(AV44Liqimportarauxtrnwwds_3_tfempcod) ,
                                           Short.valueOf(AV45Liqimportarauxtrnwwds_4_tfempcod_to) ,
                                           Integer.valueOf(AV47Liqimportarauxtrnwwds_6_tfempnom_sels.size()) ,
                                           AV46Liqimportarauxtrnwwds_5_tfempnom ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV46Liqimportarauxtrnwwds_5_tfempnom = GXutil.concat( GXutil.rtrim( AV46Liqimportarauxtrnwwds_5_tfempnom), "%", "") ;
      /* Using cursor P00352 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV42Liqimportarauxtrnwwds_1_tfclicod), Integer.valueOf(AV43Liqimportarauxtrnwwds_2_tfclicod_to), Short.valueOf(AV44Liqimportarauxtrnwwds_3_tfempcod), Short.valueOf(AV45Liqimportarauxtrnwwds_4_tfempcod_to), lV46Liqimportarauxtrnwwds_5_tfempnom});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk352 = false ;
         A2EmpNom = P00352_A2EmpNom[0] ;
         A1EmpCod = P00352_A1EmpCod[0] ;
         A3CliCod = P00352_A3CliCod[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00352_A2EmpNom[0], A2EmpNom) == 0 ) )
         {
            brk352 = false ;
            A1EmpCod = P00352_A1EmpCod[0] ;
            A3CliCod = P00352_A3CliCod[0] ;
            AV30count = (long)(AV30count+1) ;
            brk352 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2EmpNom)==0) )
         {
            AV22Option = A2EmpNom ;
            AV23Options.add(AV22Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk352 )
         {
            brk352 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liqimportarauxtrnwwgetfilterdata.this.AV24OptionsJson;
      this.aP4[0] = liqimportarauxtrnwwgetfilterdata.this.AV27OptionsDescJson;
      this.aP5[0] = liqimportarauxtrnwwgetfilterdata.this.AV29OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24OptionsJson = "" ;
      AV27OptionsDescJson = "" ;
      AV29OptionIndexesJson = "" ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFEmpNom = "" ;
      AV15TFEmpNom_SelsJson = "" ;
      AV17TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A2EmpNom = "" ;
      AV46Liqimportarauxtrnwwds_5_tfempnom = "" ;
      AV47Liqimportarauxtrnwwds_6_tfempnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV46Liqimportarauxtrnwwds_5_tfempnom = "" ;
      P00352_A2EmpNom = new String[] {""} ;
      P00352_A1EmpCod = new short[1] ;
      P00352_A3CliCod = new int[1] ;
      AV22Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqimportarauxtrnwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00352_A2EmpNom, P00352_A1EmpCod, P00352_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13TFEmpCod ;
   private short AV14TFEmpCod_To ;
   private short AV44Liqimportarauxtrnwwds_3_tfempcod ;
   private short AV45Liqimportarauxtrnwwds_4_tfempcod_to ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV40GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV42Liqimportarauxtrnwwds_1_tfclicod ;
   private int AV43Liqimportarauxtrnwwds_2_tfclicod_to ;
   private int AV47Liqimportarauxtrnwwds_6_tfempnom_sels_size ;
   private int A3CliCod ;
   private long AV30count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk352 ;
   private String AV24OptionsJson ;
   private String AV27OptionsDescJson ;
   private String AV29OptionIndexesJson ;
   private String AV15TFEmpNom_SelsJson ;
   private String AV20DDOName ;
   private String AV18SearchTxt ;
   private String AV19SearchTxtTo ;
   private String AV16TFEmpNom ;
   private String A2EmpNom ;
   private String AV46Liqimportarauxtrnwwds_5_tfempnom ;
   private String lV46Liqimportarauxtrnwwds_5_tfempnom ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00352_A2EmpNom ;
   private short[] P00352_A1EmpCod ;
   private int[] P00352_A3CliCod ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV17TFEmpNom_Sels ;
   private GXSimpleCollection<String> AV47Liqimportarauxtrnwwds_6_tfempnom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class liqimportarauxtrnwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00352( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV47Liqimportarauxtrnwwds_6_tfempnom_sels ,
                                          int AV42Liqimportarauxtrnwwds_1_tfclicod ,
                                          int AV43Liqimportarauxtrnwwds_2_tfclicod_to ,
                                          short AV44Liqimportarauxtrnwwds_3_tfempcod ,
                                          short AV45Liqimportarauxtrnwwds_4_tfempcod_to ,
                                          int AV47Liqimportarauxtrnwwds_6_tfempnom_sels_size ,
                                          String AV46Liqimportarauxtrnwwds_5_tfempnom ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[5];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT EmpNom, EmpCod, CliCod FROM Empresa" ;
      if ( ! (0==AV42Liqimportarauxtrnwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      if ( ! (0==AV43Liqimportarauxtrnwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( ! (0==AV44Liqimportarauxtrnwwds_3_tfempcod) )
      {
         addWhere(sWhereString, "(EmpCod >= ?)");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( ! (0==AV45Liqimportarauxtrnwwds_4_tfempcod_to) )
      {
         addWhere(sWhereString, "(EmpCod <= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ( AV47Liqimportarauxtrnwwds_6_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Liqimportarauxtrnwwds_5_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( AV47Liqimportarauxtrnwwds_6_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Liqimportarauxtrnwwds_6_tfempnom_sels, "EmpNom IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmpNom" ;
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
                  return conditional_P00352(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00352", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
      }
   }

}

