package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class templaterecibowwgetfilterdata extends GXProcedure
{
   public templaterecibowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( templaterecibowwgetfilterdata.class ), "" );
   }

   public templaterecibowwgetfilterdata( int remoteHandle ,
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
      templaterecibowwgetfilterdata.this.aP5 = new String[] {""};
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
      templaterecibowwgetfilterdata.this.AV32DDOName = aP0;
      templaterecibowwgetfilterdata.this.AV33SearchTxt = aP1;
      templaterecibowwgetfilterdata.this.AV34SearchTxtTo = aP2;
      templaterecibowwgetfilterdata.this.aP3 = aP3;
      templaterecibowwgetfilterdata.this.aP4 = aP4;
      templaterecibowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV39EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      templaterecibowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV39EmpCod = GXt_int1 ;
      GXt_int3 = AV40CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      templaterecibowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV40CliCod = GXt_int3 ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTemplateRecibo", GXv_boolean6) ;
      templaterecibowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV32DDOName), "DDO_TEMPRECDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADTEMPRECDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV35OptionsJson = AV22Options.toJSonString(false) ;
      AV36OptionsDescJson = AV24OptionsDesc.toJSonString(false) ;
      AV37OptionIndexesJson = AV25OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("TemplateReciboWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TemplateReciboWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("TemplateReciboWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPRECSEC") == 0 )
         {
            AV11TFTempRecSec = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFTempRecSec_To = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPRECDESCRIP") == 0 )
         {
            AV14TFTempRecDescrip = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPRECDESCRIP_SEL") == 0 )
         {
            AV13TFTempRecDescrip_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFTempRecDescrip_Sels.fromJSonString(AV13TFTempRecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPRECTIPORECIBO_SEL") == 0 )
         {
            AV16TFTempRecTipoRecibo_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFTempRecTipoRecibo_Sels.fromJSonString(AV16TFTempRecTipoRecibo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPRECPAGESIZE") == 0 )
         {
            AV18TFTempRecPageSize = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFTempRecPageSize_To = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTEMPRECDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFTempRecDescrip = AV33SearchTxt ;
      AV15TFTempRecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Templaterecibowwds_1_tftemprecsec = AV11TFTempRecSec ;
      AV47Templaterecibowwds_2_tftemprecsec_to = AV12TFTempRecSec_To ;
      AV48Templaterecibowwds_3_tftemprecdescrip = AV14TFTempRecDescrip ;
      AV49Templaterecibowwds_4_tftemprecdescrip_sels = AV15TFTempRecDescrip_Sels ;
      AV50Templaterecibowwds_5_tftemprectiporecibo_sels = AV17TFTempRecTipoRecibo_Sels ;
      AV51Templaterecibowwds_6_tftemprecpagesize = AV18TFTempRecPageSize ;
      AV52Templaterecibowwds_7_tftemprecpagesize_to = AV19TFTempRecPageSize_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A571TempRecDescrip ,
                                           AV49Templaterecibowwds_4_tftemprecdescrip_sels ,
                                           A574TempRecTipoRecibo ,
                                           AV50Templaterecibowwds_5_tftemprectiporecibo_sels ,
                                           Short.valueOf(AV46Templaterecibowwds_1_tftemprecsec) ,
                                           Short.valueOf(AV47Templaterecibowwds_2_tftemprecsec_to) ,
                                           Integer.valueOf(AV49Templaterecibowwds_4_tftemprecdescrip_sels.size()) ,
                                           AV48Templaterecibowwds_3_tftemprecdescrip ,
                                           Integer.valueOf(AV50Templaterecibowwds_5_tftemprectiporecibo_sels.size()) ,
                                           Short.valueOf(AV51Templaterecibowwds_6_tftemprecpagesize) ,
                                           Short.valueOf(AV52Templaterecibowwds_7_tftemprecpagesize_to) ,
                                           Short.valueOf(A86TempRecSec) ,
                                           Short.valueOf(A575TempRecPageSize) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV40CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Templaterecibowwds_3_tftemprecdescrip = GXutil.concat( GXutil.rtrim( AV48Templaterecibowwds_3_tftemprecdescrip), "%", "") ;
      /* Using cursor P011Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV40CliCod), Short.valueOf(AV46Templaterecibowwds_1_tftemprecsec), Short.valueOf(AV47Templaterecibowwds_2_tftemprecsec_to), lV48Templaterecibowwds_3_tftemprecdescrip, Short.valueOf(AV51Templaterecibowwds_6_tftemprecpagesize), Short.valueOf(AV52Templaterecibowwds_7_tftemprecpagesize_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk11Y2 = false ;
         A3CliCod = P011Y2_A3CliCod[0] ;
         A571TempRecDescrip = P011Y2_A571TempRecDescrip[0] ;
         A575TempRecPageSize = P011Y2_A575TempRecPageSize[0] ;
         A574TempRecTipoRecibo = P011Y2_A574TempRecTipoRecibo[0] ;
         A86TempRecSec = P011Y2_A86TempRecSec[0] ;
         A1EmpCod = P011Y2_A1EmpCod[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P011Y2_A571TempRecDescrip[0], A571TempRecDescrip) == 0 ) )
         {
            brk11Y2 = false ;
            A3CliCod = P011Y2_A3CliCod[0] ;
            A86TempRecSec = P011Y2_A86TempRecSec[0] ;
            A1EmpCod = P011Y2_A1EmpCod[0] ;
            AV26count = (long)(AV26count+1) ;
            brk11Y2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A571TempRecDescrip)==0) )
         {
            AV21Option = A571TempRecDescrip ;
            AV22Options.add(AV21Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk11Y2 )
         {
            brk11Y2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = templaterecibowwgetfilterdata.this.AV35OptionsJson;
      this.aP4[0] = templaterecibowwgetfilterdata.this.AV36OptionsDescJson;
      this.aP5[0] = templaterecibowwgetfilterdata.this.AV37OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35OptionsJson = "" ;
      AV36OptionsDescJson = "" ;
      AV37OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFTempRecDescrip = "" ;
      AV13TFTempRecDescrip_SelsJson = "" ;
      AV15TFTempRecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFTempRecTipoRecibo_SelsJson = "" ;
      AV17TFTempRecTipoRecibo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A571TempRecDescrip = "" ;
      AV48Templaterecibowwds_3_tftemprecdescrip = "" ;
      AV49Templaterecibowwds_4_tftemprecdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Templaterecibowwds_5_tftemprectiporecibo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV48Templaterecibowwds_3_tftemprecdescrip = "" ;
      A574TempRecTipoRecibo = "" ;
      P011Y2_A3CliCod = new int[1] ;
      P011Y2_A571TempRecDescrip = new String[] {""} ;
      P011Y2_A575TempRecPageSize = new short[1] ;
      P011Y2_A574TempRecTipoRecibo = new String[] {""} ;
      P011Y2_A86TempRecSec = new short[1] ;
      P011Y2_A1EmpCod = new short[1] ;
      AV21Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.templaterecibowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P011Y2_A3CliCod, P011Y2_A571TempRecDescrip, P011Y2_A575TempRecPageSize, P011Y2_A574TempRecTipoRecibo, P011Y2_A86TempRecSec, P011Y2_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV39EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFTempRecSec ;
   private short AV12TFTempRecSec_To ;
   private short AV18TFTempRecPageSize ;
   private short AV19TFTempRecPageSize_To ;
   private short AV46Templaterecibowwds_1_tftemprecsec ;
   private short AV47Templaterecibowwds_2_tftemprecsec_to ;
   private short AV51Templaterecibowwds_6_tftemprecpagesize ;
   private short AV52Templaterecibowwds_7_tftemprecpagesize_to ;
   private short A86TempRecSec ;
   private short A575TempRecPageSize ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV40CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV44GXV1 ;
   private int AV49Templaterecibowwds_4_tftemprecdescrip_sels_size ;
   private int AV50Templaterecibowwds_5_tftemprectiporecibo_sels_size ;
   private int A3CliCod ;
   private long AV26count ;
   private String scmdbuf ;
   private String A574TempRecTipoRecibo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk11Y2 ;
   private String AV35OptionsJson ;
   private String AV36OptionsDescJson ;
   private String AV37OptionIndexesJson ;
   private String AV13TFTempRecDescrip_SelsJson ;
   private String AV16TFTempRecTipoRecibo_SelsJson ;
   private String AV32DDOName ;
   private String AV33SearchTxt ;
   private String AV34SearchTxtTo ;
   private String AV14TFTempRecDescrip ;
   private String AV41MenuOpcCod ;
   private String A571TempRecDescrip ;
   private String AV48Templaterecibowwds_3_tftemprecdescrip ;
   private String lV48Templaterecibowwds_3_tftemprecdescrip ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P011Y2_A3CliCod ;
   private String[] P011Y2_A571TempRecDescrip ;
   private short[] P011Y2_A575TempRecPageSize ;
   private String[] P011Y2_A574TempRecTipoRecibo ;
   private short[] P011Y2_A86TempRecSec ;
   private short[] P011Y2_A1EmpCod ;
   private GXSimpleCollection<String> AV17TFTempRecTipoRecibo_Sels ;
   private GXSimpleCollection<String> AV50Templaterecibowwds_5_tftemprectiporecibo_sels ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV24OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private GXSimpleCollection<String> AV15TFTempRecDescrip_Sels ;
   private GXSimpleCollection<String> AV49Templaterecibowwds_4_tftemprecdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class templaterecibowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P011Y2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A571TempRecDescrip ,
                                          GXSimpleCollection<String> AV49Templaterecibowwds_4_tftemprecdescrip_sels ,
                                          String A574TempRecTipoRecibo ,
                                          GXSimpleCollection<String> AV50Templaterecibowwds_5_tftemprectiporecibo_sels ,
                                          short AV46Templaterecibowwds_1_tftemprecsec ,
                                          short AV47Templaterecibowwds_2_tftemprecsec_to ,
                                          int AV49Templaterecibowwds_4_tftemprecdescrip_sels_size ,
                                          String AV48Templaterecibowwds_3_tftemprecdescrip ,
                                          int AV50Templaterecibowwds_5_tftemprectiporecibo_sels_size ,
                                          short AV51Templaterecibowwds_6_tftemprecpagesize ,
                                          short AV52Templaterecibowwds_7_tftemprecpagesize_to ,
                                          short A86TempRecSec ,
                                          short A575TempRecPageSize ,
                                          int A3CliCod ,
                                          int AV40CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, TempRecDescrip, TempRecPageSize, TempRecTipoRecibo, TempRecSec, EmpCod FROM TemplateRecibo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV46Templaterecibowwds_1_tftemprecsec) )
      {
         addWhere(sWhereString, "(TempRecSec >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV47Templaterecibowwds_2_tftemprecsec_to) )
      {
         addWhere(sWhereString, "(TempRecSec <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( AV49Templaterecibowwds_4_tftemprecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Templaterecibowwds_3_tftemprecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TempRecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV49Templaterecibowwds_4_tftemprecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Templaterecibowwds_4_tftemprecdescrip_sels, "TempRecDescrip IN (", ")")+")");
      }
      if ( AV50Templaterecibowwds_5_tftemprectiporecibo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Templaterecibowwds_5_tftemprectiporecibo_sels, "TempRecTipoRecibo IN (", ")")+")");
      }
      if ( ! (0==AV51Templaterecibowwds_6_tftemprecpagesize) )
      {
         addWhere(sWhereString, "(TempRecPageSize >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV52Templaterecibowwds_7_tftemprecpagesize_to) )
      {
         addWhere(sWhereString, "(TempRecPageSize <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TempRecDescrip" ;
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
                  return conditional_P011Y2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011Y2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
      }
   }

}

