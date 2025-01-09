package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class periodowwgetfilterdata extends GXProcedure
{
   public periodowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodowwgetfilterdata.class ), "" );
   }

   public periodowwgetfilterdata( int remoteHandle ,
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
      periodowwgetfilterdata.this.aP5 = new String[] {""};
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
      periodowwgetfilterdata.this.AV30DDOName = aP0;
      periodowwgetfilterdata.this.AV31SearchTxt = aP1;
      periodowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      periodowwgetfilterdata.this.aP3 = aP3;
      periodowwgetfilterdata.this.aP4 = aP4;
      periodowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      periodowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      periodowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPeriodo", GXv_boolean6) ;
      periodowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_PERIODODESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADPERIODODESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("PeriodoWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PeriodoWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("PeriodoWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODOANIO") == 0 )
         {
            AV11TFPeriodoAnio = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPeriodoAnio_To = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODODESCRIP") == 0 )
         {
            AV16TFPeriodoDescrip = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODODESCRIP_SEL") == 0 )
         {
            AV15TFPeriodoDescrip_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFPeriodoDescrip_Sels.fromJSonString(AV15TFPeriodoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODOCNTLIQ") == 0 )
         {
            AV39TFPeriodoCntLiq = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFPeriodoCntLiq_To = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPERIODODESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFPeriodoDescrip = AV31SearchTxt ;
      AV17TFPeriodoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Periodowwds_1_tfperiodoanio = AV11TFPeriodoAnio ;
      AV49Periodowwds_2_tfperiodoanio_to = AV12TFPeriodoAnio_To ;
      AV50Periodowwds_3_tfperiododescrip = AV16TFPeriodoDescrip ;
      AV51Periodowwds_4_tfperiododescrip_sels = AV17TFPeriodoDescrip_Sels ;
      AV52Periodowwds_5_tfperiodocntliq = AV39TFPeriodoCntLiq ;
      AV53Periodowwds_6_tfperiodocntliq_to = AV40TFPeriodoCntLiq_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1732PeriodoDescrip ,
                                           AV51Periodowwds_4_tfperiododescrip_sels ,
                                           Short.valueOf(AV48Periodowwds_1_tfperiodoanio) ,
                                           Short.valueOf(AV49Periodowwds_2_tfperiodoanio_to) ,
                                           Integer.valueOf(AV51Periodowwds_4_tfperiododescrip_sels.size()) ,
                                           AV50Periodowwds_3_tfperiododescrip ,
                                           Short.valueOf(A1730PeriodoAnio) ,
                                           Short.valueOf(AV52Periodowwds_5_tfperiodocntliq) ,
                                           Short.valueOf(A1735PeriodoCntLiq) ,
                                           Short.valueOf(AV53Periodowwds_6_tfperiodocntliq_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV37EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV50Periodowwds_3_tfperiododescrip = GXutil.concat( GXutil.rtrim( AV50Periodowwds_3_tfperiododescrip), "%", "") ;
      /* Using cursor P01JI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), Short.valueOf(AV48Periodowwds_1_tfperiodoanio), Short.valueOf(AV49Periodowwds_2_tfperiodoanio_to), lV50Periodowwds_3_tfperiododescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1JI2 = false ;
         A1732PeriodoDescrip = P01JI2_A1732PeriodoDescrip[0] ;
         A1730PeriodoAnio = P01JI2_A1730PeriodoAnio[0] ;
         A1729PeriodoLiq = P01JI2_A1729PeriodoLiq[0] ;
         A1EmpCod = P01JI2_A1EmpCod[0] ;
         A3CliCod = P01JI2_A3CliCod[0] ;
         GXt_int1 = A1735PeriodoCntLiq ;
         GXv_int2[0] = GXt_int1 ;
         new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int2) ;
         periodowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
         A1735PeriodoCntLiq = GXt_int1 ;
         if ( (0==AV52Periodowwds_5_tfperiodocntliq) || ( ( A1735PeriodoCntLiq >= AV52Periodowwds_5_tfperiodocntliq ) ) )
         {
            if ( (0==AV53Periodowwds_6_tfperiodocntliq_to) || ( ( A1735PeriodoCntLiq <= AV53Periodowwds_6_tfperiodocntliq_to ) ) )
            {
               AV24count = 0 ;
               while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01JI2_A1732PeriodoDescrip[0], A1732PeriodoDescrip) == 0 ) )
               {
                  brk1JI2 = false ;
                  A1729PeriodoLiq = P01JI2_A1729PeriodoLiq[0] ;
                  A1EmpCod = P01JI2_A1EmpCod[0] ;
                  A3CliCod = P01JI2_A3CliCod[0] ;
                  AV24count = (long)(AV24count+1) ;
                  brk1JI2 = true ;
                  pr_default.readNext(0);
               }
               if ( ! (GXutil.strcmp("", A1732PeriodoDescrip)==0) )
               {
                  AV19Option = A1732PeriodoDescrip ;
                  AV20Options.add(AV19Option, 0);
                  AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
               }
               if ( AV20Options.size() == 50 )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
            }
         }
         if ( ! brk1JI2 )
         {
            brk1JI2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = periodowwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = periodowwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = periodowwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFPeriodoDescrip = "" ;
      AV15TFPeriodoDescrip_SelsJson = "" ;
      AV17TFPeriodoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43MenuOpcCod = "" ;
      A1732PeriodoDescrip = "" ;
      AV50Periodowwds_3_tfperiododescrip = "" ;
      AV51Periodowwds_4_tfperiododescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV50Periodowwds_3_tfperiododescrip = "" ;
      P01JI2_A1732PeriodoDescrip = new String[] {""} ;
      P01JI2_A1730PeriodoAnio = new short[1] ;
      P01JI2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P01JI2_A1EmpCod = new short[1] ;
      P01JI2_A3CliCod = new int[1] ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      GXv_int2 = new short[1] ;
      AV19Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01JI2_A1732PeriodoDescrip, P01JI2_A1730PeriodoAnio, P01JI2_A1729PeriodoLiq, P01JI2_A1EmpCod, P01JI2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short AV11TFPeriodoAnio ;
   private short AV12TFPeriodoAnio_To ;
   private short AV39TFPeriodoCntLiq ;
   private short AV40TFPeriodoCntLiq_To ;
   private short AV48Periodowwds_1_tfperiodoanio ;
   private short AV49Periodowwds_2_tfperiodoanio_to ;
   private short AV52Periodowwds_5_tfperiodocntliq ;
   private short AV53Periodowwds_6_tfperiodocntliq_to ;
   private short A1730PeriodoAnio ;
   private short A1735PeriodoCntLiq ;
   private short A1EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV46GXV1 ;
   private int AV51Periodowwds_4_tfperiododescrip_sels_size ;
   private int A3CliCod ;
   private long AV24count ;
   private String scmdbuf ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1JI2 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV15TFPeriodoDescrip_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV16TFPeriodoDescrip ;
   private String AV43MenuOpcCod ;
   private String A1732PeriodoDescrip ;
   private String AV50Periodowwds_3_tfperiododescrip ;
   private String lV50Periodowwds_3_tfperiododescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JI2_A1732PeriodoDescrip ;
   private short[] P01JI2_A1730PeriodoAnio ;
   private java.util.Date[] P01JI2_A1729PeriodoLiq ;
   private short[] P01JI2_A1EmpCod ;
   private int[] P01JI2_A3CliCod ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV17TFPeriodoDescrip_Sels ;
   private GXSimpleCollection<String> AV51Periodowwds_4_tfperiododescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class periodowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1732PeriodoDescrip ,
                                          GXSimpleCollection<String> AV51Periodowwds_4_tfperiododescrip_sels ,
                                          short AV48Periodowwds_1_tfperiodoanio ,
                                          short AV49Periodowwds_2_tfperiodoanio_to ,
                                          int AV51Periodowwds_4_tfperiododescrip_sels_size ,
                                          String AV50Periodowwds_3_tfperiododescrip ,
                                          short A1730PeriodoAnio ,
                                          short AV52Periodowwds_5_tfperiodocntliq ,
                                          short A1735PeriodoCntLiq ,
                                          short AV53Periodowwds_6_tfperiodocntliq_to ,
                                          int A3CliCod ,
                                          int AV38CliCod ,
                                          short A1EmpCod ,
                                          short AV37EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PeriodoDescrip, PeriodoAnio, PeriodoLiq, EmpCod, CliCod FROM Periodo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV48Periodowwds_1_tfperiodoanio) )
      {
         addWhere(sWhereString, "(PeriodoAnio >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV49Periodowwds_2_tfperiodoanio_to) )
      {
         addWhere(sWhereString, "(PeriodoAnio <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV51Periodowwds_4_tfperiododescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Periodowwds_3_tfperiododescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PeriodoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV51Periodowwds_4_tfperiododescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Periodowwds_4_tfperiododescrip_sels, "PeriodoDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoDescrip" ;
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
                  return conditional_P01JI2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}

