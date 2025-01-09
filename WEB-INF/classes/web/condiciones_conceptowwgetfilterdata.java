package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condiciones_conceptowwgetfilterdata extends GXProcedure
{
   public condiciones_conceptowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condiciones_conceptowwgetfilterdata.class ), "" );
   }

   public condiciones_conceptowwgetfilterdata( int remoteHandle ,
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
      condiciones_conceptowwgetfilterdata.this.aP5 = new String[] {""};
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
      condiciones_conceptowwgetfilterdata.this.AV30DDOName = aP0;
      condiciones_conceptowwgetfilterdata.this.AV31SearchTxt = aP1;
      condiciones_conceptowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      condiciones_conceptowwgetfilterdata.this.aP3 = aP3;
      condiciones_conceptowwgetfilterdata.this.aP4 = aP4;
      condiciones_conceptowwgetfilterdata.this.aP5 = aP5;
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
      condiciones_conceptowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      condiciones_conceptowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondiciones_concepto", GXv_boolean6) ;
      condiciones_conceptowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_CONCONDICION") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCONDICIONOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_CONDICIONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDICIONDESCRIPOPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV25Session.getValue("Condiciones_conceptoWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Condiciones_conceptoWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("Condiciones_conceptoWWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV11TFConCondicion_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFConCondicion_Sels.fromJSonString(AV11TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONPAIS") == 0 )
         {
            AV13TFCondicionPais = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFCondicionPais_To = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONDESCRIP") == 0 )
         {
            AV16TFCondicionDescrip = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDICIONDESCRIP_SEL") == 0 )
         {
            AV15TFCondicionDescrip_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFCondicionDescrip_Sels.fromJSonString(AV15TFCondicionDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDLIQBASICA_SEL") == 0 )
         {
            AV39TFCondLiqBasica_Sel = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDSEGPLA_SEL") == 0 )
         {
            AV42TFCondSegPla_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFCondSegPla_Sels.fromJSonString(AV42TFCondSegPla_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV44MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONCONDICIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Condiciones_conceptowwds_1_tfconcondicion_sels = AV12TFConCondicion_Sels ;
      AV50Condiciones_conceptowwds_2_tfcondicionpais = AV13TFCondicionPais ;
      AV51Condiciones_conceptowwds_3_tfcondicionpais_to = AV14TFCondicionPais_To ;
      AV52Condiciones_conceptowwds_4_tfcondiciondescrip = AV16TFCondicionDescrip ;
      AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels = AV17TFCondicionDescrip_Sels ;
      AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel = AV39TFCondLiqBasica_Sel ;
      AV55Condiciones_conceptowwds_7_tfcondsegpla_sels = AV43TFCondSegPla_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A953ConCondicion ,
                                           AV49Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                           A1758CondicionDescrip ,
                                           AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                           Byte.valueOf(A1786CondSegPla) ,
                                           AV55Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                           Integer.valueOf(AV49Condiciones_conceptowwds_1_tfconcondicion_sels.size()) ,
                                           Short.valueOf(AV50Condiciones_conceptowwds_2_tfcondicionpais) ,
                                           Short.valueOf(AV51Condiciones_conceptowwds_3_tfcondicionpais_to) ,
                                           Integer.valueOf(AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels.size()) ,
                                           AV52Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                           Byte.valueOf(AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel) ,
                                           Integer.valueOf(AV55Condiciones_conceptowwds_7_tfcondsegpla_sels.size()) ,
                                           Short.valueOf(A1757CondicionPais) ,
                                           Boolean.valueOf(A1779CondLiqBasica) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV52Condiciones_conceptowwds_4_tfcondiciondescrip = GXutil.concat( GXutil.rtrim( AV52Condiciones_conceptowwds_4_tfcondiciondescrip), "%", "") ;
      /* Using cursor P01KS2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV50Condiciones_conceptowwds_2_tfcondicionpais), Short.valueOf(AV51Condiciones_conceptowwds_3_tfcondicionpais_to), lV52Condiciones_conceptowwds_4_tfcondiciondescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1786CondSegPla = P01KS2_A1786CondSegPla[0] ;
         A1779CondLiqBasica = P01KS2_A1779CondLiqBasica[0] ;
         A1758CondicionDescrip = P01KS2_A1758CondicionDescrip[0] ;
         A1757CondicionPais = P01KS2_A1757CondicionPais[0] ;
         A953ConCondicion = P01KS2_A953ConCondicion[0] ;
         if ( ! (GXutil.strcmp("", A953ConCondicion)==0) )
         {
            AV19Option = A953ConCondicion ;
            AV20Options.add(AV19Option, 0);
         }
         if ( AV20Options.size() == 50 )
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
      /* 'LOADCONDICIONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFCondicionDescrip = AV31SearchTxt ;
      AV17TFCondicionDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Condiciones_conceptowwds_1_tfconcondicion_sels = AV12TFConCondicion_Sels ;
      AV50Condiciones_conceptowwds_2_tfcondicionpais = AV13TFCondicionPais ;
      AV51Condiciones_conceptowwds_3_tfcondicionpais_to = AV14TFCondicionPais_To ;
      AV52Condiciones_conceptowwds_4_tfcondiciondescrip = AV16TFCondicionDescrip ;
      AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels = AV17TFCondicionDescrip_Sels ;
      AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel = AV39TFCondLiqBasica_Sel ;
      AV55Condiciones_conceptowwds_7_tfcondsegpla_sels = AV43TFCondSegPla_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A953ConCondicion ,
                                           AV49Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                           A1758CondicionDescrip ,
                                           AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                           Byte.valueOf(A1786CondSegPla) ,
                                           AV55Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                           Integer.valueOf(AV49Condiciones_conceptowwds_1_tfconcondicion_sels.size()) ,
                                           Short.valueOf(AV50Condiciones_conceptowwds_2_tfcondicionpais) ,
                                           Short.valueOf(AV51Condiciones_conceptowwds_3_tfcondicionpais_to) ,
                                           Integer.valueOf(AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels.size()) ,
                                           AV52Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                           Byte.valueOf(AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel) ,
                                           Integer.valueOf(AV55Condiciones_conceptowwds_7_tfcondsegpla_sels.size()) ,
                                           Short.valueOf(A1757CondicionPais) ,
                                           Boolean.valueOf(A1779CondLiqBasica) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV52Condiciones_conceptowwds_4_tfcondiciondescrip = GXutil.concat( GXutil.rtrim( AV52Condiciones_conceptowwds_4_tfcondiciondescrip), "%", "") ;
      /* Using cursor P01KS3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV50Condiciones_conceptowwds_2_tfcondicionpais), Short.valueOf(AV51Condiciones_conceptowwds_3_tfcondicionpais_to), lV52Condiciones_conceptowwds_4_tfcondiciondescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1KS3 = false ;
         A1758CondicionDescrip = P01KS3_A1758CondicionDescrip[0] ;
         A1786CondSegPla = P01KS3_A1786CondSegPla[0] ;
         A1779CondLiqBasica = P01KS3_A1779CondLiqBasica[0] ;
         A1757CondicionPais = P01KS3_A1757CondicionPais[0] ;
         A953ConCondicion = P01KS3_A953ConCondicion[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01KS3_A1758CondicionDescrip[0], A1758CondicionDescrip) == 0 ) )
         {
            brk1KS3 = false ;
            A953ConCondicion = P01KS3_A953ConCondicion[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1KS3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1758CondicionDescrip)==0) )
         {
            AV19Option = A1758CondicionDescrip ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KS3 )
         {
            brk1KS3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = condiciones_conceptowwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = condiciones_conceptowwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = condiciones_conceptowwgetfilterdata.this.AV35OptionIndexesJson;
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
      GXv_int2 = new short[1] ;
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
      AV11TFConCondicion_SelsJson = "" ;
      AV12TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFCondicionDescrip = "" ;
      AV15TFCondicionDescrip_SelsJson = "" ;
      AV17TFCondicionDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFCondSegPla_SelsJson = "" ;
      AV43TFCondSegPla_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV44MenuOpcCod = "" ;
      A953ConCondicion = "" ;
      AV49Condiciones_conceptowwds_1_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Condiciones_conceptowwds_4_tfcondiciondescrip = "" ;
      AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Condiciones_conceptowwds_7_tfcondsegpla_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      lV52Condiciones_conceptowwds_4_tfcondiciondescrip = "" ;
      A1758CondicionDescrip = "" ;
      P01KS2_A1786CondSegPla = new byte[1] ;
      P01KS2_A1779CondLiqBasica = new boolean[] {false} ;
      P01KS2_A1758CondicionDescrip = new String[] {""} ;
      P01KS2_A1757CondicionPais = new short[1] ;
      P01KS2_A953ConCondicion = new String[] {""} ;
      AV19Option = "" ;
      P01KS3_A1758CondicionDescrip = new String[] {""} ;
      P01KS3_A1786CondSegPla = new byte[1] ;
      P01KS3_A1779CondLiqBasica = new boolean[] {false} ;
      P01KS3_A1757CondicionPais = new short[1] ;
      P01KS3_A953ConCondicion = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condiciones_conceptowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01KS2_A1786CondSegPla, P01KS2_A1779CondLiqBasica, P01KS2_A1758CondicionDescrip, P01KS2_A1757CondicionPais, P01KS2_A953ConCondicion
            }
            , new Object[] {
            P01KS3_A1758CondicionDescrip, P01KS3_A1786CondSegPla, P01KS3_A1779CondLiqBasica, P01KS3_A1757CondicionPais, P01KS3_A953ConCondicion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV39TFCondLiqBasica_Sel ;
   private byte AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel ;
   private byte A1786CondSegPla ;
   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV13TFCondicionPais ;
   private short AV14TFCondicionPais_To ;
   private short AV50Condiciones_conceptowwds_2_tfcondicionpais ;
   private short AV51Condiciones_conceptowwds_3_tfcondicionpais_to ;
   private short A1757CondicionPais ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV49Condiciones_conceptowwds_1_tfconcondicion_sels_size ;
   private int AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size ;
   private int AV55Condiciones_conceptowwds_7_tfcondsegpla_sels_size ;
   private long AV24count ;
   private String A953ConCondicion ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1779CondLiqBasica ;
   private boolean brk1KS3 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV11TFConCondicion_SelsJson ;
   private String AV15TFCondicionDescrip_SelsJson ;
   private String AV42TFCondSegPla_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV16TFCondicionDescrip ;
   private String AV44MenuOpcCod ;
   private String AV52Condiciones_conceptowwds_4_tfcondiciondescrip ;
   private String lV52Condiciones_conceptowwds_4_tfcondiciondescrip ;
   private String A1758CondicionDescrip ;
   private String AV19Option ;
   private GXSimpleCollection<Byte> AV43TFCondSegPla_Sels ;
   private GXSimpleCollection<Byte> AV55Condiciones_conceptowwds_7_tfcondsegpla_sels ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01KS2_A1786CondSegPla ;
   private boolean[] P01KS2_A1779CondLiqBasica ;
   private String[] P01KS2_A1758CondicionDescrip ;
   private short[] P01KS2_A1757CondicionPais ;
   private String[] P01KS2_A953ConCondicion ;
   private String[] P01KS3_A1758CondicionDescrip ;
   private byte[] P01KS3_A1786CondSegPla ;
   private boolean[] P01KS3_A1779CondLiqBasica ;
   private short[] P01KS3_A1757CondicionPais ;
   private String[] P01KS3_A953ConCondicion ;
   private GXSimpleCollection<String> AV12TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV49Condiciones_conceptowwds_1_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV17TFCondicionDescrip_Sels ;
   private GXSimpleCollection<String> AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class condiciones_conceptowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV49Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                          String A1758CondicionDescrip ,
                                          GXSimpleCollection<String> AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                          byte A1786CondSegPla ,
                                          GXSimpleCollection<Byte> AV55Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                          int AV49Condiciones_conceptowwds_1_tfconcondicion_sels_size ,
                                          short AV50Condiciones_conceptowwds_2_tfcondicionpais ,
                                          short AV51Condiciones_conceptowwds_3_tfcondicionpais_to ,
                                          int AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size ,
                                          String AV52Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                          byte AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel ,
                                          int AV55Condiciones_conceptowwds_7_tfcondsegpla_sels_size ,
                                          short A1757CondicionPais ,
                                          boolean A1779CondLiqBasica )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS CondSegPla, NULL AS CondLiqBasica, NULL AS CondicionDescrip, NULL AS CondicionPais, ConCondicion FROM ( SELECT CondSegPla, CondLiqBasica," ;
      scmdbuf += " CondicionDescrip, CondicionPais, ConCondicion FROM Condiciones_concepto" ;
      if ( AV49Condiciones_conceptowwds_1_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Condiciones_conceptowwds_1_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ! (0==AV50Condiciones_conceptowwds_2_tfcondicionpais) )
      {
         addWhere(sWhereString, "(CondicionPais >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV51Condiciones_conceptowwds_3_tfcondicionpais_to) )
      {
         addWhere(sWhereString, "(CondicionPais <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Condiciones_conceptowwds_4_tfcondiciondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondicionDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels, "CondicionDescrip IN (", ")")+")");
      }
      if ( AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel == 1 )
      {
         addWhere(sWhereString, "(CondLiqBasica = TRUE)");
      }
      if ( AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel == 2 )
      {
         addWhere(sWhereString, "(CondLiqBasica = FALSE)");
      }
      if ( AV55Condiciones_conceptowwds_7_tfcondsegpla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Condiciones_conceptowwds_7_tfcondsegpla_sels, "CondSegPla IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConCondicion" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY ConCondicion" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01KS3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV49Condiciones_conceptowwds_1_tfconcondicion_sels ,
                                          String A1758CondicionDescrip ,
                                          GXSimpleCollection<String> AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels ,
                                          byte A1786CondSegPla ,
                                          GXSimpleCollection<Byte> AV55Condiciones_conceptowwds_7_tfcondsegpla_sels ,
                                          int AV49Condiciones_conceptowwds_1_tfconcondicion_sels_size ,
                                          short AV50Condiciones_conceptowwds_2_tfcondicionpais ,
                                          short AV51Condiciones_conceptowwds_3_tfcondicionpais_to ,
                                          int AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size ,
                                          String AV52Condiciones_conceptowwds_4_tfcondiciondescrip ,
                                          byte AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel ,
                                          int AV55Condiciones_conceptowwds_7_tfcondsegpla_sels_size ,
                                          short A1757CondicionPais ,
                                          boolean A1779CondLiqBasica )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CondicionDescrip, CondSegPla, CondLiqBasica, CondicionPais, ConCondicion FROM Condiciones_concepto" ;
      if ( AV49Condiciones_conceptowwds_1_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Condiciones_conceptowwds_1_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ! (0==AV50Condiciones_conceptowwds_2_tfcondicionpais) )
      {
         addWhere(sWhereString, "(CondicionPais >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV51Condiciones_conceptowwds_3_tfcondicionpais_to) )
      {
         addWhere(sWhereString, "(CondicionPais <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Condiciones_conceptowwds_4_tfcondiciondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondicionDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Condiciones_conceptowwds_5_tfcondiciondescrip_sels, "CondicionDescrip IN (", ")")+")");
      }
      if ( AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel == 1 )
      {
         addWhere(sWhereString, "(CondLiqBasica = TRUE)");
      }
      if ( AV54Condiciones_conceptowwds_6_tfcondliqbasica_sel == 2 )
      {
         addWhere(sWhereString, "(CondLiqBasica = FALSE)");
      }
      if ( AV55Condiciones_conceptowwds_7_tfcondsegpla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Condiciones_conceptowwds_7_tfcondsegpla_sels, "CondSegPla IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CondicionDescrip" ;
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
                  return conditional_P01KS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
            case 1 :
                  return conditional_P01KS3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KS3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
      }
   }

}

