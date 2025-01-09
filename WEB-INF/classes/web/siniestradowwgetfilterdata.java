package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siniestradowwgetfilterdata extends GXProcedure
{
   public siniestradowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siniestradowwgetfilterdata.class ), "" );
   }

   public siniestradowwgetfilterdata( int remoteHandle ,
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
      siniestradowwgetfilterdata.this.aP5 = new String[] {""};
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
      siniestradowwgetfilterdata.this.AV16DDOName = aP0;
      siniestradowwgetfilterdata.this.AV14SearchTxt = aP1;
      siniestradowwgetfilterdata.this.AV15SearchTxtTo = aP2;
      siniestradowwgetfilterdata.this.aP3 = aP3;
      siniestradowwgetfilterdata.this.aP4 = aP4;
      siniestradowwgetfilterdata.this.aP5 = aP5;
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
      siniestradowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV35CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      siniestradowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV35CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSiniestrado", GXv_boolean6) ;
      siniestradowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SINIECODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSINIECODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SINIEDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADSINIEDESCRIOPTIONS' */
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
      if ( GXutil.strcmp(AV27Session.getValue("SiniestradoWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SiniestradoWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("SiniestradoWWGridState"), null, null);
      }
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV43GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINIECODIGO") == 0 )
         {
            AV10TFSinieCodigo = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINIECODIGO_SEL") == 0 )
         {
            AV38TFSinieCodigo_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFSinieCodigo_Sels.fromJSonString(AV38TFSinieCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINIEDESCRI") == 0 )
         {
            AV12TFSinieDescri = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINIEDESCRI_SEL") == 0 )
         {
            AV33TFSinieDescri_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFSinieDescri_Sels.fromJSonString(AV33TFSinieDescri_SelsJson, null);
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
      /* 'LOADSINIECODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSinieCodigo = AV14SearchTxt ;
      AV39TFSinieCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Siniestradowwds_1_tfsiniecodigo = AV10TFSinieCodigo ;
      AV46Siniestradowwds_2_tfsiniecodigo_sels = AV39TFSinieCodigo_Sels ;
      AV47Siniestradowwds_3_tfsiniedescri = AV12TFSinieDescri ;
      AV48Siniestradowwds_4_tfsiniedescri_sels = AV34TFSinieDescri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A19SinieCodigo ,
                                           AV46Siniestradowwds_2_tfsiniecodigo_sels ,
                                           A333SinieDescri ,
                                           AV48Siniestradowwds_4_tfsiniedescri_sels ,
                                           Integer.valueOf(AV46Siniestradowwds_2_tfsiniecodigo_sels.size()) ,
                                           AV45Siniestradowwds_1_tfsiniecodigo ,
                                           Integer.valueOf(AV48Siniestradowwds_4_tfsiniedescri_sels.size()) ,
                                           AV47Siniestradowwds_3_tfsiniedescri } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV45Siniestradowwds_1_tfsiniecodigo = GXutil.padr( GXutil.rtrim( AV45Siniestradowwds_1_tfsiniecodigo), 4, "%") ;
      lV47Siniestradowwds_3_tfsiniedescri = GXutil.concat( GXutil.rtrim( AV47Siniestradowwds_3_tfsiniedescri), "%", "") ;
      /* Using cursor P00882 */
      pr_default.execute(0, new Object[] {lV45Siniestradowwds_1_tfsiniecodigo, lV47Siniestradowwds_3_tfsiniedescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A333SinieDescri = P00882_A333SinieDescri[0] ;
         A19SinieCodigo = P00882_A19SinieCodigo[0] ;
         if ( ! (GXutil.strcmp("", A19SinieCodigo)==0) )
         {
            AV18Option = A19SinieCodigo ;
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
      /* 'LOADSINIEDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSinieDescri = AV14SearchTxt ;
      AV34TFSinieDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Siniestradowwds_1_tfsiniecodigo = AV10TFSinieCodigo ;
      AV46Siniestradowwds_2_tfsiniecodigo_sels = AV39TFSinieCodigo_Sels ;
      AV47Siniestradowwds_3_tfsiniedescri = AV12TFSinieDescri ;
      AV48Siniestradowwds_4_tfsiniedescri_sels = AV34TFSinieDescri_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A19SinieCodigo ,
                                           AV46Siniestradowwds_2_tfsiniecodigo_sels ,
                                           A333SinieDescri ,
                                           AV48Siniestradowwds_4_tfsiniedescri_sels ,
                                           Integer.valueOf(AV46Siniestradowwds_2_tfsiniecodigo_sels.size()) ,
                                           AV45Siniestradowwds_1_tfsiniecodigo ,
                                           Integer.valueOf(AV48Siniestradowwds_4_tfsiniedescri_sels.size()) ,
                                           AV47Siniestradowwds_3_tfsiniedescri } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV45Siniestradowwds_1_tfsiniecodigo = GXutil.padr( GXutil.rtrim( AV45Siniestradowwds_1_tfsiniecodigo), 4, "%") ;
      lV47Siniestradowwds_3_tfsiniedescri = GXutil.concat( GXutil.rtrim( AV47Siniestradowwds_3_tfsiniedescri), "%", "") ;
      /* Using cursor P00883 */
      pr_default.execute(1, new Object[] {lV45Siniestradowwds_1_tfsiniecodigo, lV47Siniestradowwds_3_tfsiniedescri});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk883 = false ;
         A333SinieDescri = P00883_A333SinieDescri[0] ;
         A19SinieCodigo = P00883_A19SinieCodigo[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00883_A333SinieDescri[0], A333SinieDescri) == 0 ) )
         {
            brk883 = false ;
            A19SinieCodigo = P00883_A19SinieCodigo[0] ;
            AV26count = (long)(AV26count+1) ;
            brk883 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A333SinieDescri)==0) )
         {
            AV18Option = A333SinieDescri ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk883 )
         {
            brk883 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = siniestradowwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = siniestradowwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = siniestradowwgetfilterdata.this.AV25OptionIndexesJson;
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
      AV10TFSinieCodigo = "" ;
      AV38TFSinieCodigo_SelsJson = "" ;
      AV39TFSinieCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSinieDescri = "" ;
      AV33TFSinieDescri_SelsJson = "" ;
      AV34TFSinieDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40MenuOpcCod = "" ;
      A19SinieCodigo = "" ;
      AV45Siniestradowwds_1_tfsiniecodigo = "" ;
      AV46Siniestradowwds_2_tfsiniecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47Siniestradowwds_3_tfsiniedescri = "" ;
      AV48Siniestradowwds_4_tfsiniedescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV45Siniestradowwds_1_tfsiniecodigo = "" ;
      lV47Siniestradowwds_3_tfsiniedescri = "" ;
      A333SinieDescri = "" ;
      P00882_A333SinieDescri = new String[] {""} ;
      P00882_A19SinieCodigo = new String[] {""} ;
      AV18Option = "" ;
      P00883_A333SinieDescri = new String[] {""} ;
      P00883_A19SinieCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siniestradowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00882_A333SinieDescri, P00882_A19SinieCodigo
            }
            , new Object[] {
            P00883_A333SinieDescri, P00883_A19SinieCodigo
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
   private int AV46Siniestradowwds_2_tfsiniecodigo_sels_size ;
   private int AV48Siniestradowwds_4_tfsiniedescri_sels_size ;
   private long AV26count ;
   private String AV10TFSinieCodigo ;
   private String A19SinieCodigo ;
   private String AV45Siniestradowwds_1_tfsiniecodigo ;
   private String scmdbuf ;
   private String lV45Siniestradowwds_1_tfsiniecodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk883 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV38TFSinieCodigo_SelsJson ;
   private String AV33TFSinieDescri_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV12TFSinieDescri ;
   private String AV40MenuOpcCod ;
   private String AV47Siniestradowwds_3_tfsiniedescri ;
   private String lV47Siniestradowwds_3_tfsiniedescri ;
   private String A333SinieDescri ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00882_A333SinieDescri ;
   private String[] P00882_A19SinieCodigo ;
   private String[] P00883_A333SinieDescri ;
   private String[] P00883_A19SinieCodigo ;
   private GXSimpleCollection<String> AV39TFSinieCodigo_Sels ;
   private GXSimpleCollection<String> AV46Siniestradowwds_2_tfsiniecodigo_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV34TFSinieDescri_Sels ;
   private GXSimpleCollection<String> AV48Siniestradowwds_4_tfsiniedescri_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class siniestradowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00882( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A19SinieCodigo ,
                                          GXSimpleCollection<String> AV46Siniestradowwds_2_tfsiniecodigo_sels ,
                                          String A333SinieDescri ,
                                          GXSimpleCollection<String> AV48Siniestradowwds_4_tfsiniedescri_sels ,
                                          int AV46Siniestradowwds_2_tfsiniecodigo_sels_size ,
                                          String AV45Siniestradowwds_1_tfsiniecodigo ,
                                          int AV48Siniestradowwds_4_tfsiniedescri_sels_size ,
                                          String AV47Siniestradowwds_3_tfsiniedescri )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS SinieDescri, SinieCodigo FROM ( SELECT SinieDescri, SinieCodigo FROM Siniestrado" ;
      if ( ( AV46Siniestradowwds_2_tfsiniecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Siniestradowwds_1_tfsiniecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinieCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV46Siniestradowwds_2_tfsiniecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Siniestradowwds_2_tfsiniecodigo_sels, "SinieCodigo IN (", ")")+")");
      }
      if ( ( AV48Siniestradowwds_4_tfsiniedescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Siniestradowwds_3_tfsiniedescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinieDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV48Siniestradowwds_4_tfsiniedescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Siniestradowwds_4_tfsiniedescri_sels, "SinieDescri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SinieCodigo" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY SinieCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00883( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A19SinieCodigo ,
                                          GXSimpleCollection<String> AV46Siniestradowwds_2_tfsiniecodigo_sels ,
                                          String A333SinieDescri ,
                                          GXSimpleCollection<String> AV48Siniestradowwds_4_tfsiniedescri_sels ,
                                          int AV46Siniestradowwds_2_tfsiniecodigo_sels_size ,
                                          String AV45Siniestradowwds_1_tfsiniecodigo ,
                                          int AV48Siniestradowwds_4_tfsiniedescri_sels_size ,
                                          String AV47Siniestradowwds_3_tfsiniedescri )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SinieDescri, SinieCodigo FROM Siniestrado" ;
      if ( ( AV46Siniestradowwds_2_tfsiniecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Siniestradowwds_1_tfsiniecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinieCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV46Siniestradowwds_2_tfsiniecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Siniestradowwds_2_tfsiniecodigo_sels, "SinieCodigo IN (", ")")+")");
      }
      if ( ( AV48Siniestradowwds_4_tfsiniedescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Siniestradowwds_3_tfsiniedescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinieDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV48Siniestradowwds_4_tfsiniedescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Siniestradowwds_4_tfsiniedescri_sels, "SinieDescri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SinieDescri" ;
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
                  return conditional_P00882(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
            case 1 :
                  return conditional_P00883(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00882", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00883", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
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
                  stmt.setString(sIdx, (String)parms[2], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

