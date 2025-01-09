package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parentescowwgetfilterdata extends GXProcedure
{
   public parentescowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parentescowwgetfilterdata.class ), "" );
   }

   public parentescowwgetfilterdata( int remoteHandle ,
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
      parentescowwgetfilterdata.this.aP5 = new String[] {""};
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
      parentescowwgetfilterdata.this.AV21DDOName = aP0;
      parentescowwgetfilterdata.this.AV19SearchTxt = aP1;
      parentescowwgetfilterdata.this.AV20SearchTxtTo = aP2;
      parentescowwgetfilterdata.this.aP3 = aP3;
      parentescowwgetfilterdata.this.aP4 = aP4;
      parentescowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV45EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      parentescowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV45EmpCod = GXt_int1 ;
      GXt_int3 = AV44CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      parentescowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV44CliCod = GXt_int3 ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParentesco", GXv_boolean6) ;
      parentescowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_PARCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADPARCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_PARDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADPARDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV25OptionsJson = AV24Options.toJSonString(false) ;
      AV28OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV30OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV32Session.getValue("ParentescoWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ParentescoWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("ParentescoWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARCOD") == 0 )
         {
            AV10TFParCod = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARCOD_SEL") == 0 )
         {
            AV38TFParCod_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFParCod_Sels.fromJSonString(AV38TFParCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARDESCRIP") == 0 )
         {
            AV12TFParDescrip = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARDESCRIP_SEL") == 0 )
         {
            AV40TFParDescrip_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFParDescrip_Sels.fromJSonString(AV40TFParDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPARCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFParCod = AV19SearchTxt ;
      AV39TFParCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Parentescowwds_1_tfparcod = AV10TFParCod ;
      AV53Parentescowwds_2_tfparcod_sels = AV39TFParCod_Sels ;
      AV54Parentescowwds_3_tfpardescrip = AV12TFParDescrip ;
      AV55Parentescowwds_4_tfpardescrip_sels = AV41TFParDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A30ParCod ,
                                           AV53Parentescowwds_2_tfparcod_sels ,
                                           A313ParDescrip ,
                                           AV55Parentescowwds_4_tfpardescrip_sels ,
                                           Integer.valueOf(AV53Parentescowwds_2_tfparcod_sels.size()) ,
                                           AV52Parentescowwds_1_tfparcod ,
                                           Integer.valueOf(AV55Parentescowwds_4_tfpardescrip_sels.size()) ,
                                           AV54Parentescowwds_3_tfpardescrip ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Parentescowwds_1_tfparcod = GXutil.padr( GXutil.rtrim( AV52Parentescowwds_1_tfparcod), 20, "%") ;
      lV54Parentescowwds_3_tfpardescrip = GXutil.concat( GXutil.rtrim( AV54Parentescowwds_3_tfpardescrip), "%", "") ;
      /* Using cursor P00802 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), lV52Parentescowwds_1_tfparcod, lV54Parentescowwds_3_tfpardescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk802 = false ;
         A3CliCod = P00802_A3CliCod[0] ;
         A30ParCod = P00802_A30ParCod[0] ;
         A313ParDescrip = P00802_A313ParDescrip[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00802_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P00802_A30ParCod[0], A30ParCod) == 0 ) )
         {
            brk802 = false ;
            AV31count = (long)(AV31count+1) ;
            brk802 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A30ParCod)==0) )
         {
            AV23Option = A30ParCod ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk802 )
         {
            brk802 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPARDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFParDescrip = AV19SearchTxt ;
      AV41TFParDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Parentescowwds_1_tfparcod = AV10TFParCod ;
      AV53Parentescowwds_2_tfparcod_sels = AV39TFParCod_Sels ;
      AV54Parentescowwds_3_tfpardescrip = AV12TFParDescrip ;
      AV55Parentescowwds_4_tfpardescrip_sels = AV41TFParDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A30ParCod ,
                                           AV53Parentescowwds_2_tfparcod_sels ,
                                           A313ParDescrip ,
                                           AV55Parentescowwds_4_tfpardescrip_sels ,
                                           Integer.valueOf(AV53Parentescowwds_2_tfparcod_sels.size()) ,
                                           AV52Parentescowwds_1_tfparcod ,
                                           Integer.valueOf(AV55Parentescowwds_4_tfpardescrip_sels.size()) ,
                                           AV54Parentescowwds_3_tfpardescrip ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Parentescowwds_1_tfparcod = GXutil.padr( GXutil.rtrim( AV52Parentescowwds_1_tfparcod), 20, "%") ;
      lV54Parentescowwds_3_tfpardescrip = GXutil.concat( GXutil.rtrim( AV54Parentescowwds_3_tfpardescrip), "%", "") ;
      /* Using cursor P00803 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV44CliCod), lV52Parentescowwds_1_tfparcod, lV54Parentescowwds_3_tfpardescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk804 = false ;
         A3CliCod = P00803_A3CliCod[0] ;
         A313ParDescrip = P00803_A313ParDescrip[0] ;
         A30ParCod = P00803_A30ParCod[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00803_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P00803_A313ParDescrip[0], A313ParDescrip) == 0 ) )
         {
            brk804 = false ;
            A30ParCod = P00803_A30ParCod[0] ;
            AV31count = (long)(AV31count+1) ;
            brk804 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A313ParDescrip)==0) )
         {
            AV23Option = A313ParDescrip ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk804 )
         {
            brk804 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = parentescowwgetfilterdata.this.AV25OptionsJson;
      this.aP4[0] = parentescowwgetfilterdata.this.AV28OptionsDescJson;
      this.aP5[0] = parentescowwgetfilterdata.this.AV30OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25OptionsJson = "" ;
      AV28OptionsDescJson = "" ;
      AV30OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Session = httpContext.getWebSession();
      AV34GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFParCod = "" ;
      AV38TFParCod_SelsJson = "" ;
      AV39TFParCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFParDescrip = "" ;
      AV40TFParDescrip_SelsJson = "" ;
      AV41TFParDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47MenuOpcCod = "" ;
      A30ParCod = "" ;
      AV52Parentescowwds_1_tfparcod = "" ;
      AV53Parentescowwds_2_tfparcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Parentescowwds_3_tfpardescrip = "" ;
      AV55Parentescowwds_4_tfpardescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV52Parentescowwds_1_tfparcod = "" ;
      lV54Parentescowwds_3_tfpardescrip = "" ;
      A313ParDescrip = "" ;
      P00802_A3CliCod = new int[1] ;
      P00802_A30ParCod = new String[] {""} ;
      P00802_A313ParDescrip = new String[] {""} ;
      AV23Option = "" ;
      P00803_A3CliCod = new int[1] ;
      P00803_A313ParDescrip = new String[] {""} ;
      P00803_A30ParCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parentescowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00802_A3CliCod, P00802_A30ParCod, P00802_A313ParDescrip
            }
            , new Object[] {
            P00803_A3CliCod, P00803_A313ParDescrip, P00803_A30ParCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV45EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV53Parentescowwds_2_tfparcod_sels_size ;
   private int AV55Parentescowwds_4_tfpardescrip_sels_size ;
   private int A3CliCod ;
   private long AV31count ;
   private String AV10TFParCod ;
   private String A30ParCod ;
   private String AV52Parentescowwds_1_tfparcod ;
   private String scmdbuf ;
   private String lV52Parentescowwds_1_tfparcod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk802 ;
   private boolean brk804 ;
   private String AV25OptionsJson ;
   private String AV28OptionsDescJson ;
   private String AV30OptionIndexesJson ;
   private String AV38TFParCod_SelsJson ;
   private String AV40TFParDescrip_SelsJson ;
   private String AV21DDOName ;
   private String AV19SearchTxt ;
   private String AV20SearchTxtTo ;
   private String AV12TFParDescrip ;
   private String AV47MenuOpcCod ;
   private String AV54Parentescowwds_3_tfpardescrip ;
   private String lV54Parentescowwds_3_tfpardescrip ;
   private String A313ParDescrip ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00802_A3CliCod ;
   private String[] P00802_A30ParCod ;
   private String[] P00802_A313ParDescrip ;
   private int[] P00803_A3CliCod ;
   private String[] P00803_A313ParDescrip ;
   private String[] P00803_A30ParCod ;
   private GXSimpleCollection<String> AV39TFParCod_Sels ;
   private GXSimpleCollection<String> AV53Parentescowwds_2_tfparcod_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private GXSimpleCollection<String> AV41TFParDescrip_Sels ;
   private GXSimpleCollection<String> AV55Parentescowwds_4_tfpardescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class parentescowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00802( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A30ParCod ,
                                          GXSimpleCollection<String> AV53Parentescowwds_2_tfparcod_sels ,
                                          String A313ParDescrip ,
                                          GXSimpleCollection<String> AV55Parentescowwds_4_tfpardescrip_sels ,
                                          int AV53Parentescowwds_2_tfparcod_sels_size ,
                                          String AV52Parentescowwds_1_tfparcod ,
                                          int AV55Parentescowwds_4_tfpardescrip_sels_size ,
                                          String AV54Parentescowwds_3_tfpardescrip ,
                                          int AV44CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, ParCod, ParDescrip FROM Parentesco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Parentescowwds_2_tfparcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Parentescowwds_1_tfparcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV53Parentescowwds_2_tfparcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Parentescowwds_2_tfparcod_sels, "ParCod IN (", ")")+")");
      }
      if ( ( AV55Parentescowwds_4_tfpardescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Parentescowwds_3_tfpardescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV55Parentescowwds_4_tfpardescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Parentescowwds_4_tfpardescrip_sels, "ParDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ParCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00803( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A30ParCod ,
                                          GXSimpleCollection<String> AV53Parentescowwds_2_tfparcod_sels ,
                                          String A313ParDescrip ,
                                          GXSimpleCollection<String> AV55Parentescowwds_4_tfpardescrip_sels ,
                                          int AV53Parentescowwds_2_tfparcod_sels_size ,
                                          String AV52Parentescowwds_1_tfparcod ,
                                          int AV55Parentescowwds_4_tfpardescrip_sels_size ,
                                          String AV54Parentescowwds_3_tfpardescrip ,
                                          int AV44CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, ParDescrip, ParCod FROM Parentesco" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Parentescowwds_2_tfparcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Parentescowwds_1_tfparcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV53Parentescowwds_2_tfparcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Parentescowwds_2_tfparcod_sels, "ParCod IN (", ")")+")");
      }
      if ( ( AV55Parentescowwds_4_tfpardescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Parentescowwds_3_tfpardescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV55Parentescowwds_4_tfpardescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Parentescowwds_4_tfpardescrip_sels, "ParDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ParDescrip" ;
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
                  return conditional_P00802(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
            case 1 :
                  return conditional_P00803(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00802", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00803", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
      }
   }

}

