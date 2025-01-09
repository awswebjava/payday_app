package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionajustewwgetfilterdata extends GXProcedure
{
   public liquidacionajustewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionajustewwgetfilterdata.class ), "" );
   }

   public liquidacionajustewwgetfilterdata( int remoteHandle ,
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
      liquidacionajustewwgetfilterdata.this.aP5 = new String[] {""};
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
      liquidacionajustewwgetfilterdata.this.AV28DDOName = aP0;
      liquidacionajustewwgetfilterdata.this.AV29SearchTxt = aP1;
      liquidacionajustewwgetfilterdata.this.AV30SearchTxtTo = aP2;
      liquidacionajustewwgetfilterdata.this.aP3 = aP3;
      liquidacionajustewwgetfilterdata.this.aP4 = aP4;
      liquidacionajustewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacionajustewwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacionajustewwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste", GXv_boolean6) ;
      liquidacionajustewwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_LIQAJUOBS") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQAJUOBSOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("LiquidacionAjusteWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionAjusteWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("LiquidacionAjusteWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUNRO") == 0 )
         {
            AV11TFLiqAjuNro = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLiqAjuNro_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUOBS") == 0 )
         {
            AV14TFLiqAjuObs = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUOBS_SEL") == 0 )
         {
            AV13TFLiqAjuObs_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFLiqAjuObs_Sels.fromJSonString(AV13TFLiqAjuObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV36CliCod = (int)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV35EmpCod = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV37LiqNro = (int)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV38LegNumero = (int)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQAJUOBSOPTIONS' Routine */
      returnInSub = false ;
      AV14TFLiqAjuObs = AV29SearchTxt ;
      AV15TFLiqAjuObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Liquidacionajustewwds_1_clicod = AV36CliCod ;
      AV45Liquidacionajustewwds_2_empcod = AV35EmpCod ;
      AV46Liquidacionajustewwds_3_liqnro = AV37LiqNro ;
      AV47Liquidacionajustewwds_4_legnumero = AV38LegNumero ;
      AV48Liquidacionajustewwds_5_tfliqajunro = AV11TFLiqAjuNro ;
      AV49Liquidacionajustewwds_6_tfliqajunro_to = AV12TFLiqAjuNro_To ;
      AV50Liquidacionajustewwds_7_tfliqajuobs = AV14TFLiqAjuObs ;
      AV51Liquidacionajustewwds_8_tfliqajuobs_sels = AV15TFLiqAjuObs_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1542LiqAjuObs ,
                                           AV51Liquidacionajustewwds_8_tfliqajuobs_sels ,
                                           Short.valueOf(AV48Liquidacionajustewwds_5_tfliqajunro) ,
                                           Short.valueOf(AV49Liquidacionajustewwds_6_tfliqajunro_to) ,
                                           Integer.valueOf(AV51Liquidacionajustewwds_8_tfliqajuobs_sels.size()) ,
                                           AV50Liquidacionajustewwds_7_tfliqajuobs ,
                                           Short.valueOf(A1541LiqAjuNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV36CliCod) ,
                                           Integer.valueOf(AV44Liquidacionajustewwds_1_clicod) ,
                                           Short.valueOf(AV45Liquidacionajustewwds_2_empcod) ,
                                           Integer.valueOf(AV46Liquidacionajustewwds_3_liqnro) ,
                                           Integer.valueOf(AV47Liquidacionajustewwds_4_legnumero) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV50Liquidacionajustewwds_7_tfliqajuobs = GXutil.concat( GXutil.rtrim( AV50Liquidacionajustewwds_7_tfliqajuobs), "%", "") ;
      /* Using cursor P01FD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44Liquidacionajustewwds_1_clicod), Short.valueOf(AV45Liquidacionajustewwds_2_empcod), Integer.valueOf(AV46Liquidacionajustewwds_3_liqnro), Integer.valueOf(AV47Liquidacionajustewwds_4_legnumero), Integer.valueOf(AV36CliCod), Short.valueOf(AV48Liquidacionajustewwds_5_tfliqajunro), Short.valueOf(AV49Liquidacionajustewwds_6_tfliqajunro_to), lV50Liquidacionajustewwds_7_tfliqajuobs});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1FD2 = false ;
         A3CliCod = P01FD2_A3CliCod[0] ;
         A1EmpCod = P01FD2_A1EmpCod[0] ;
         A31LiqNro = P01FD2_A31LiqNro[0] ;
         A6LegNumero = P01FD2_A6LegNumero[0] ;
         A1542LiqAjuObs = P01FD2_A1542LiqAjuObs[0] ;
         A1541LiqAjuNro = P01FD2_A1541LiqAjuNro[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01FD2_A3CliCod[0] == A3CliCod ) && ( P01FD2_A1EmpCod[0] == A1EmpCod ) && ( P01FD2_A31LiqNro[0] == A31LiqNro ) && ( P01FD2_A6LegNumero[0] == A6LegNumero ) )
         {
            if ( ! ( ( GXutil.strcmp(P01FD2_A1542LiqAjuObs[0], A1542LiqAjuObs) == 0 ) ) )
            {
               if (true) break;
            }
            brk1FD2 = false ;
            A1541LiqAjuNro = P01FD2_A1541LiqAjuNro[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1FD2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1542LiqAjuObs)==0) )
         {
            AV17Option = A1542LiqAjuObs ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FD2 )
         {
            brk1FD2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacionajustewwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = liquidacionajustewwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = liquidacionajustewwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFLiqAjuObs = "" ;
      AV13TFLiqAjuObs_SelsJson = "" ;
      AV15TFLiqAjuObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A1542LiqAjuObs = "" ;
      AV50Liquidacionajustewwds_7_tfliqajuobs = "" ;
      AV51Liquidacionajustewwds_8_tfliqajuobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV50Liquidacionajustewwds_7_tfliqajuobs = "" ;
      P01FD2_A3CliCod = new int[1] ;
      P01FD2_A1EmpCod = new short[1] ;
      P01FD2_A31LiqNro = new int[1] ;
      P01FD2_A6LegNumero = new int[1] ;
      P01FD2_A1542LiqAjuObs = new String[] {""} ;
      P01FD2_A1541LiqAjuNro = new short[1] ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionajustewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01FD2_A3CliCod, P01FD2_A1EmpCod, P01FD2_A31LiqNro, P01FD2_A6LegNumero, P01FD2_A1542LiqAjuObs, P01FD2_A1541LiqAjuNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFLiqAjuNro ;
   private short AV12TFLiqAjuNro_To ;
   private short AV45Liquidacionajustewwds_2_empcod ;
   private short AV48Liquidacionajustewwds_5_tfliqajunro ;
   private short AV49Liquidacionajustewwds_6_tfliqajunro_to ;
   private short A1541LiqAjuNro ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV42GXV1 ;
   private int AV37LiqNro ;
   private int AV38LegNumero ;
   private int AV44Liquidacionajustewwds_1_clicod ;
   private int AV46Liquidacionajustewwds_3_liqnro ;
   private int AV47Liquidacionajustewwds_4_legnumero ;
   private int AV51Liquidacionajustewwds_8_tfliqajuobs_sels_size ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private long AV22count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1FD2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFLiqAjuObs_SelsJson ;
   private String A1542LiqAjuObs ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFLiqAjuObs ;
   private String AV39MenuOpcCod ;
   private String AV50Liquidacionajustewwds_7_tfliqajuobs ;
   private String lV50Liquidacionajustewwds_7_tfliqajuobs ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01FD2_A3CliCod ;
   private short[] P01FD2_A1EmpCod ;
   private int[] P01FD2_A31LiqNro ;
   private int[] P01FD2_A6LegNumero ;
   private String[] P01FD2_A1542LiqAjuObs ;
   private short[] P01FD2_A1541LiqAjuNro ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFLiqAjuObs_Sels ;
   private GXSimpleCollection<String> AV51Liquidacionajustewwds_8_tfliqajuobs_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class liquidacionajustewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01FD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1542LiqAjuObs ,
                                          GXSimpleCollection<String> AV51Liquidacionajustewwds_8_tfliqajuobs_sels ,
                                          short AV48Liquidacionajustewwds_5_tfliqajunro ,
                                          short AV49Liquidacionajustewwds_6_tfliqajunro_to ,
                                          int AV51Liquidacionajustewwds_8_tfliqajuobs_sels_size ,
                                          String AV50Liquidacionajustewwds_7_tfliqajuobs ,
                                          short A1541LiqAjuNro ,
                                          int A3CliCod ,
                                          int AV36CliCod ,
                                          int AV44Liquidacionajustewwds_1_clicod ,
                                          short AV45Liquidacionajustewwds_2_empcod ,
                                          int AV46Liquidacionajustewwds_3_liqnro ,
                                          int AV47Liquidacionajustewwds_4_legnumero ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuObs, LiqAjuNro FROM LiquidacionAjuste" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV48Liquidacionajustewwds_5_tfliqajunro) )
      {
         addWhere(sWhereString, "(LiqAjuNro >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV49Liquidacionajustewwds_6_tfliqajunro_to) )
      {
         addWhere(sWhereString, "(LiqAjuNro <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV51Liquidacionajustewwds_8_tfliqajuobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Liquidacionajustewwds_7_tfliqajuobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqAjuObs) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV51Liquidacionajustewwds_8_tfliqajuobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Liquidacionajustewwds_8_tfliqajuobs_sels, "LiqAjuObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuObs" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01FD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
      }
   }

}

