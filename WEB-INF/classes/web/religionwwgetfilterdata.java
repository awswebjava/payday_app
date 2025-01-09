package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class religionwwgetfilterdata extends GXProcedure
{
   public religionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( religionwwgetfilterdata.class ), "" );
   }

   public religionwwgetfilterdata( int remoteHandle ,
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
      religionwwgetfilterdata.this.aP5 = new String[] {""};
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
      religionwwgetfilterdata.this.AV29DDOName = aP0;
      religionwwgetfilterdata.this.AV30SearchTxt = aP1;
      religionwwgetfilterdata.this.AV31SearchTxtTo = aP2;
      religionwwgetfilterdata.this.aP3 = aP3;
      religionwwgetfilterdata.this.aP4 = aP4;
      religionwwgetfilterdata.this.aP5 = aP5;
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
      religionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      religionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWReligion", GXv_boolean6) ;
      religionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_RELIGID") == 0 )
         {
            /* Execute user subroutine: 'LOADRELIGIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_RELIGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADRELIGNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("ReligionWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ReligionWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("ReligionWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRELIGID") == 0 )
         {
            AV12TFReligId = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRELIGID_SEL") == 0 )
         {
            AV11TFReligId_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFReligId_Sels.fromJSonString(AV11TFReligId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRELIGNOMBRE") == 0 )
         {
            AV15TFReligNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRELIGNOMBRE_SEL") == 0 )
         {
            AV14TFReligNombre_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFReligNombre_Sels.fromJSonString(AV14TFReligNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADRELIGIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFReligId = AV30SearchTxt ;
      AV13TFReligId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Religionwwds_1_tfreligid = AV12TFReligId ;
      AV44Religionwwds_2_tfreligid_sels = AV13TFReligId_Sels ;
      AV45Religionwwds_3_tfrelignombre = AV15TFReligNombre ;
      AV46Religionwwds_4_tfrelignombre_sels = AV16TFReligNombre_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1229ReligId ,
                                           AV44Religionwwds_2_tfreligid_sels ,
                                           A1283ReligNombre ,
                                           AV46Religionwwds_4_tfrelignombre_sels ,
                                           Integer.valueOf(AV44Religionwwds_2_tfreligid_sels.size()) ,
                                           AV43Religionwwds_1_tfreligid ,
                                           Integer.valueOf(AV46Religionwwds_4_tfrelignombre_sels.size()) ,
                                           AV45Religionwwds_3_tfrelignombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV43Religionwwds_1_tfreligid = GXutil.padr( GXutil.rtrim( AV43Religionwwds_1_tfreligid), 20, "%") ;
      lV45Religionwwds_3_tfrelignombre = GXutil.concat( GXutil.rtrim( AV45Religionwwds_3_tfrelignombre), "%", "") ;
      /* Using cursor P01HK2 */
      pr_default.execute(0, new Object[] {lV43Religionwwds_1_tfreligid, lV45Religionwwds_3_tfrelignombre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1283ReligNombre = P01HK2_A1283ReligNombre[0] ;
         A1229ReligId = P01HK2_A1229ReligId[0] ;
         if ( ! (GXutil.strcmp("", A1229ReligId)==0) )
         {
            AV18Option = A1229ReligId ;
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
      /* 'LOADRELIGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFReligNombre = AV30SearchTxt ;
      AV16TFReligNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Religionwwds_1_tfreligid = AV12TFReligId ;
      AV44Religionwwds_2_tfreligid_sels = AV13TFReligId_Sels ;
      AV45Religionwwds_3_tfrelignombre = AV15TFReligNombre ;
      AV46Religionwwds_4_tfrelignombre_sels = AV16TFReligNombre_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1229ReligId ,
                                           AV44Religionwwds_2_tfreligid_sels ,
                                           A1283ReligNombre ,
                                           AV46Religionwwds_4_tfrelignombre_sels ,
                                           Integer.valueOf(AV44Religionwwds_2_tfreligid_sels.size()) ,
                                           AV43Religionwwds_1_tfreligid ,
                                           Integer.valueOf(AV46Religionwwds_4_tfrelignombre_sels.size()) ,
                                           AV45Religionwwds_3_tfrelignombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV43Religionwwds_1_tfreligid = GXutil.padr( GXutil.rtrim( AV43Religionwwds_1_tfreligid), 20, "%") ;
      lV45Religionwwds_3_tfrelignombre = GXutil.concat( GXutil.rtrim( AV45Religionwwds_3_tfrelignombre), "%", "") ;
      /* Using cursor P01HK3 */
      pr_default.execute(1, new Object[] {lV43Religionwwds_1_tfreligid, lV45Religionwwds_3_tfrelignombre});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1HK3 = false ;
         A1283ReligNombre = P01HK3_A1283ReligNombre[0] ;
         A1229ReligId = P01HK3_A1229ReligId[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01HK3_A1283ReligNombre[0], A1283ReligNombre) == 0 ) )
         {
            brk1HK3 = false ;
            A1229ReligId = P01HK3_A1229ReligId[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1HK3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1283ReligNombre)==0) )
         {
            AV18Option = A1283ReligNombre ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HK3 )
         {
            brk1HK3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = religionwwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = religionwwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = religionwwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFReligId = "" ;
      AV11TFReligId_SelsJson = "" ;
      AV13TFReligId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFReligNombre = "" ;
      AV14TFReligNombre_SelsJson = "" ;
      AV16TFReligNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A1229ReligId = "" ;
      AV43Religionwwds_1_tfreligid = "" ;
      AV44Religionwwds_2_tfreligid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45Religionwwds_3_tfrelignombre = "" ;
      AV46Religionwwds_4_tfrelignombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV43Religionwwds_1_tfreligid = "" ;
      lV45Religionwwds_3_tfrelignombre = "" ;
      A1283ReligNombre = "" ;
      P01HK2_A1283ReligNombre = new String[] {""} ;
      P01HK2_A1229ReligId = new String[] {""} ;
      AV18Option = "" ;
      P01HK3_A1283ReligNombre = new String[] {""} ;
      P01HK3_A1229ReligId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.religionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HK2_A1283ReligNombre, P01HK2_A1229ReligId
            }
            , new Object[] {
            P01HK3_A1283ReligNombre, P01HK3_A1229ReligId
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
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV44Religionwwds_2_tfreligid_sels_size ;
   private int AV46Religionwwds_4_tfrelignombre_sels_size ;
   private long AV23count ;
   private String AV12TFReligId ;
   private String A1229ReligId ;
   private String AV43Religionwwds_1_tfreligid ;
   private String scmdbuf ;
   private String lV43Religionwwds_1_tfreligid ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HK3 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV11TFReligId_SelsJson ;
   private String AV14TFReligNombre_SelsJson ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV15TFReligNombre ;
   private String AV38MenuOpcCod ;
   private String AV45Religionwwds_3_tfrelignombre ;
   private String lV45Religionwwds_3_tfrelignombre ;
   private String A1283ReligNombre ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HK2_A1283ReligNombre ;
   private String[] P01HK2_A1229ReligId ;
   private String[] P01HK3_A1283ReligNombre ;
   private String[] P01HK3_A1229ReligId ;
   private GXSimpleCollection<String> AV13TFReligId_Sels ;
   private GXSimpleCollection<String> AV44Religionwwds_2_tfreligid_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV16TFReligNombre_Sels ;
   private GXSimpleCollection<String> AV46Religionwwds_4_tfrelignombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class religionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1229ReligId ,
                                          GXSimpleCollection<String> AV44Religionwwds_2_tfreligid_sels ,
                                          String A1283ReligNombre ,
                                          GXSimpleCollection<String> AV46Religionwwds_4_tfrelignombre_sels ,
                                          int AV44Religionwwds_2_tfreligid_sels_size ,
                                          String AV43Religionwwds_1_tfreligid ,
                                          int AV46Religionwwds_4_tfrelignombre_sels_size ,
                                          String AV45Religionwwds_3_tfrelignombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS ReligNombre, ReligId FROM ( SELECT ReligNombre, ReligId FROM Religion" ;
      if ( ( AV44Religionwwds_2_tfreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Religionwwds_1_tfreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ReligId) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV44Religionwwds_2_tfreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Religionwwds_2_tfreligid_sels, "ReligId IN (", ")")+")");
      }
      if ( ( AV46Religionwwds_4_tfrelignombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Religionwwds_3_tfrelignombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ReligNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV46Religionwwds_4_tfrelignombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Religionwwds_4_tfrelignombre_sels, "ReligNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ReligId" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY ReligId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01HK3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1229ReligId ,
                                          GXSimpleCollection<String> AV44Religionwwds_2_tfreligid_sels ,
                                          String A1283ReligNombre ,
                                          GXSimpleCollection<String> AV46Religionwwds_4_tfrelignombre_sels ,
                                          int AV44Religionwwds_2_tfreligid_sels_size ,
                                          String AV43Religionwwds_1_tfreligid ,
                                          int AV46Religionwwds_4_tfrelignombre_sels_size ,
                                          String AV45Religionwwds_3_tfrelignombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT ReligNombre, ReligId FROM Religion" ;
      if ( ( AV44Religionwwds_2_tfreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Religionwwds_1_tfreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ReligId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV44Religionwwds_2_tfreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Religionwwds_2_tfreligid_sels, "ReligId IN (", ")")+")");
      }
      if ( ( AV46Religionwwds_4_tfrelignombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Religionwwds_3_tfrelignombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ReligNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV46Religionwwds_4_tfrelignombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Religionwwds_4_tfrelignombre_sels, "ReligNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ReligNombre" ;
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
                  return conditional_P01HK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
            case 1 :
                  return conditional_P01HK3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HK3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               return;
      }
   }

}

