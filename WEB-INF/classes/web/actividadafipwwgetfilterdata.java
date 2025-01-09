package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actividadafipwwgetfilterdata extends GXProcedure
{
   public actividadafipwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actividadafipwwgetfilterdata.class ), "" );
   }

   public actividadafipwwgetfilterdata( int remoteHandle ,
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
      actividadafipwwgetfilterdata.this.aP5 = new String[] {""};
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
      actividadafipwwgetfilterdata.this.AV16DDOName = aP0;
      actividadafipwwgetfilterdata.this.AV14SearchTxt = aP1;
      actividadafipwwgetfilterdata.this.AV15SearchTxtTo = aP2;
      actividadafipwwgetfilterdata.this.aP3 = aP3;
      actividadafipwwgetfilterdata.this.aP4 = aP4;
      actividadafipwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      actividadafipwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV35CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      actividadafipwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV35CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWActividadAFIP", GXv_boolean6) ;
      actividadafipwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_ACTCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADACTCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_ACTDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADACTDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("ActividadAFIPWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ActividadAFIPWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("ActividadAFIPWWGridState"), null, null);
      }
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV43GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTCODIGO") == 0 )
         {
            AV10TFActCodigo = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTCODIGO_SEL") == 0 )
         {
            AV38TFActCodigo_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFActCodigo_Sels.fromJSonString(AV38TFActCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP") == 0 )
         {
            AV12TFActDescrip = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP_SEL") == 0 )
         {
            AV33TFActDescrip_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFActDescrip_Sels.fromJSonString(AV33TFActDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV40MenuOpcCod = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV43GXV1 = (int)(AV43GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADACTCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV10TFActCodigo = AV14SearchTxt ;
      AV39TFActCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Actividadafipwwds_1_tfactcodigo = AV10TFActCodigo ;
      AV46Actividadafipwwds_2_tfactcodigo_sels = AV39TFActCodigo_Sels ;
      AV47Actividadafipwwds_3_tfactdescrip = AV12TFActDescrip ;
      AV48Actividadafipwwds_4_tfactdescrip_sels = AV34TFActDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A43ActCodigo ,
                                           AV46Actividadafipwwds_2_tfactcodigo_sels ,
                                           A108ActDescrip ,
                                           AV48Actividadafipwwds_4_tfactdescrip_sels ,
                                           Integer.valueOf(AV46Actividadafipwwds_2_tfactcodigo_sels.size()) ,
                                           AV45Actividadafipwwds_1_tfactcodigo ,
                                           Integer.valueOf(AV48Actividadafipwwds_4_tfactdescrip_sels.size()) ,
                                           AV47Actividadafipwwds_3_tfactdescrip } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV45Actividadafipwwds_1_tfactcodigo = GXutil.padr( GXutil.rtrim( AV45Actividadafipwwds_1_tfactcodigo), 8, "%") ;
      lV47Actividadafipwwds_3_tfactdescrip = GXutil.concat( GXutil.rtrim( AV47Actividadafipwwds_3_tfactdescrip), "%", "") ;
      /* Using cursor P00A72 */
      pr_default.execute(0, new Object[] {lV45Actividadafipwwds_1_tfactcodigo, lV47Actividadafipwwds_3_tfactdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A108ActDescrip = P00A72_A108ActDescrip[0] ;
         A43ActCodigo = P00A72_A43ActCodigo[0] ;
         if ( ! (GXutil.strcmp("", A43ActCodigo)==0) )
         {
            AV18Option = A43ActCodigo ;
            AV19Options.add(AV18Option, 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADACTDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFActDescrip = AV14SearchTxt ;
      AV34TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Actividadafipwwds_1_tfactcodigo = AV10TFActCodigo ;
      AV46Actividadafipwwds_2_tfactcodigo_sels = AV39TFActCodigo_Sels ;
      AV47Actividadafipwwds_3_tfactdescrip = AV12TFActDescrip ;
      AV48Actividadafipwwds_4_tfactdescrip_sels = AV34TFActDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A43ActCodigo ,
                                           AV46Actividadafipwwds_2_tfactcodigo_sels ,
                                           A108ActDescrip ,
                                           AV48Actividadafipwwds_4_tfactdescrip_sels ,
                                           Integer.valueOf(AV46Actividadafipwwds_2_tfactcodigo_sels.size()) ,
                                           AV45Actividadafipwwds_1_tfactcodigo ,
                                           Integer.valueOf(AV48Actividadafipwwds_4_tfactdescrip_sels.size()) ,
                                           AV47Actividadafipwwds_3_tfactdescrip } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV45Actividadafipwwds_1_tfactcodigo = GXutil.padr( GXutil.rtrim( AV45Actividadafipwwds_1_tfactcodigo), 8, "%") ;
      lV47Actividadafipwwds_3_tfactdescrip = GXutil.concat( GXutil.rtrim( AV47Actividadafipwwds_3_tfactdescrip), "%", "") ;
      /* Using cursor P00A73 */
      pr_default.execute(1, new Object[] {lV45Actividadafipwwds_1_tfactcodigo, lV47Actividadafipwwds_3_tfactdescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkA73 = false ;
         A108ActDescrip = P00A73_A108ActDescrip[0] ;
         A43ActCodigo = P00A73_A43ActCodigo[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00A73_A108ActDescrip[0], A108ActDescrip) == 0 ) )
         {
            brkA73 = false ;
            A43ActCodigo = P00A73_A43ActCodigo[0] ;
            AV26count = (long)(AV26count+1) ;
            brkA73 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A108ActDescrip)==0) )
         {
            AV18Option = A108ActDescrip ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkA73 )
         {
            brkA73 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = actividadafipwwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = actividadafipwwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = actividadafipwwgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFActCodigo = "" ;
      AV38TFActCodigo_SelsJson = "" ;
      AV39TFActCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFActDescrip = "" ;
      AV33TFActDescrip_SelsJson = "" ;
      AV34TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40MenuOpcCod = "" ;
      A43ActCodigo = "" ;
      AV45Actividadafipwwds_1_tfactcodigo = "" ;
      AV46Actividadafipwwds_2_tfactcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47Actividadafipwwds_3_tfactdescrip = "" ;
      AV48Actividadafipwwds_4_tfactdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV45Actividadafipwwds_1_tfactcodigo = "" ;
      lV47Actividadafipwwds_3_tfactdescrip = "" ;
      A108ActDescrip = "" ;
      P00A72_A108ActDescrip = new String[] {""} ;
      P00A72_A43ActCodigo = new String[] {""} ;
      AV18Option = "" ;
      P00A73_A108ActDescrip = new String[] {""} ;
      P00A73_A43ActCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actividadafipwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00A72_A108ActDescrip, P00A72_A43ActCodigo
            }
            , new Object[] {
            P00A73_A108ActDescrip, P00A73_A43ActCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV35CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV43GXV1 ;
   private int AV46Actividadafipwwds_2_tfactcodigo_sels_size ;
   private int AV48Actividadafipwwds_4_tfactdescrip_sels_size ;
   private long AV26count ;
   private String AV10TFActCodigo ;
   private String A43ActCodigo ;
   private String AV45Actividadafipwwds_1_tfactcodigo ;
   private String scmdbuf ;
   private String lV45Actividadafipwwds_1_tfactcodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brkA73 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV38TFActCodigo_SelsJson ;
   private String AV33TFActDescrip_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV12TFActDescrip ;
   private String AV40MenuOpcCod ;
   private String AV47Actividadafipwwds_3_tfactdescrip ;
   private String lV47Actividadafipwwds_3_tfactdescrip ;
   private String A108ActDescrip ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00A72_A108ActDescrip ;
   private String[] P00A72_A43ActCodigo ;
   private String[] P00A73_A108ActDescrip ;
   private String[] P00A73_A43ActCodigo ;
   private GXSimpleCollection<String> AV39TFActCodigo_Sels ;
   private GXSimpleCollection<String> AV46Actividadafipwwds_2_tfactcodigo_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV34TFActDescrip_Sels ;
   private GXSimpleCollection<String> AV48Actividadafipwwds_4_tfactdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class actividadafipwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00A72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A43ActCodigo ,
                                          GXSimpleCollection<String> AV46Actividadafipwwds_2_tfactcodigo_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV48Actividadafipwwds_4_tfactdescrip_sels ,
                                          int AV46Actividadafipwwds_2_tfactcodigo_sels_size ,
                                          String AV45Actividadafipwwds_1_tfactcodigo ,
                                          int AV48Actividadafipwwds_4_tfactdescrip_sels_size ,
                                          String AV47Actividadafipwwds_3_tfactdescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS ActDescrip, ActCodigo FROM ( SELECT ActDescrip, ActCodigo FROM Actividad" ;
      if ( ( AV46Actividadafipwwds_2_tfactcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Actividadafipwwds_1_tfactcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ActCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV46Actividadafipwwds_2_tfactcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Actividadafipwwds_2_tfactcodigo_sels, "ActCodigo IN (", ")")+")");
      }
      if ( ( AV48Actividadafipwwds_4_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Actividadafipwwds_3_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV48Actividadafipwwds_4_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Actividadafipwwds_4_tfactdescrip_sels, "ActDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActCodigo" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY ActCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00A73( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A43ActCodigo ,
                                          GXSimpleCollection<String> AV46Actividadafipwwds_2_tfactcodigo_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV48Actividadafipwwds_4_tfactdescrip_sels ,
                                          int AV46Actividadafipwwds_2_tfactcodigo_sels_size ,
                                          String AV45Actividadafipwwds_1_tfactcodigo ,
                                          int AV48Actividadafipwwds_4_tfactdescrip_sels_size ,
                                          String AV47Actividadafipwwds_3_tfactdescrip )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT ActDescrip, ActCodigo FROM Actividad" ;
      if ( ( AV46Actividadafipwwds_2_tfactcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Actividadafipwwds_1_tfactcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ActCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV46Actividadafipwwds_2_tfactcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Actividadafipwwds_2_tfactcodigo_sels, "ActCodigo IN (", ")")+")");
      }
      if ( ( AV48Actividadafipwwds_4_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Actividadafipwwds_3_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV48Actividadafipwwds_4_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Actividadafipwwds_4_tfactdescrip_sels, "ActDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ActDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P00A72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
            case 1 :
                  return conditional_P00A73(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00A72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00A73", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
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
                  stmt.setString(sIdx, (String)parms[2], 8);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 150);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 8);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 150);
               }
               return;
      }
   }

}

