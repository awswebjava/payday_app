package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sexoswwgetfilterdata extends GXProcedure
{
   public sexoswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sexoswwgetfilterdata.class ), "" );
   }

   public sexoswwgetfilterdata( int remoteHandle ,
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
      sexoswwgetfilterdata.this.aP5 = new String[] {""};
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
      sexoswwgetfilterdata.this.AV32DDOName = aP0;
      sexoswwgetfilterdata.this.AV33SearchTxt = aP1;
      sexoswwgetfilterdata.this.AV34SearchTxtTo = aP2;
      sexoswwgetfilterdata.this.aP3 = aP3;
      sexoswwgetfilterdata.this.aP4 = aP4;
      sexoswwgetfilterdata.this.aP5 = aP5;
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
      sexoswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV39EmpCod = GXt_int1 ;
      GXt_int3 = AV40CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      sexoswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV40CliCod = GXt_int3 ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSexos", GXv_boolean6) ;
      sexoswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV32DDOName), "DDO_SEXONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSEXONOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV32DDOName), "DDO_SEXOCODFOR") == 0 )
         {
            /* Execute user subroutine: 'LOADSEXOCODFOROPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV27Session.getValue("SexosWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SexosWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("SexosWWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOID") == 0 )
         {
            AV11TFSexoId = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFSexoId_To = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXONOMBRE") == 0 )
         {
            AV14TFSexoNombre = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXONOMBRE_SEL") == 0 )
         {
            AV13TFSexoNombre_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFSexoNombre_Sels.fromJSonString(AV13TFSexoNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOBIOLOGICO_SEL") == 0 )
         {
            AV16TFSexoBiologico_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFSexoBiologico_Sels.fromJSonString(AV16TFSexoBiologico_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOIDENTIDAD_SEL") == 0 )
         {
            AV18TFSexoIdentidad_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFSexoIdentidad_Sels.fromJSonString(AV18TFSexoIdentidad_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOCODFOR") == 0 )
         {
            AV43TFSexoCodFor = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEXOCODFOR_SEL") == 0 )
         {
            AV42TFSexoCodFor_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFSexoCodFor_Sels.fromJSonString(AV42TFSexoCodFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSEXONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV14TFSexoNombre = AV33SearchTxt ;
      AV15TFSexoNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Sexoswwds_1_tfsexoid = AV11TFSexoId ;
      AV50Sexoswwds_2_tfsexoid_to = AV12TFSexoId_To ;
      AV51Sexoswwds_3_tfsexonombre = AV14TFSexoNombre ;
      AV52Sexoswwds_4_tfsexonombre_sels = AV15TFSexoNombre_Sels ;
      AV53Sexoswwds_5_tfsexobiologico_sels = AV17TFSexoBiologico_Sels ;
      AV54Sexoswwds_6_tfsexoidentidad_sels = AV19TFSexoIdentidad_Sels ;
      AV55Sexoswwds_7_tfsexocodfor = AV43TFSexoCodFor ;
      AV56Sexoswwds_8_tfsexocodfor_sels = AV44TFSexoCodFor_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1744SexoNombre ,
                                           AV52Sexoswwds_4_tfsexonombre_sels ,
                                           A1745SexoBiologico ,
                                           AV53Sexoswwds_5_tfsexobiologico_sels ,
                                           A1746SexoIdentidad ,
                                           AV54Sexoswwds_6_tfsexoidentidad_sels ,
                                           A2092SexoCodFor ,
                                           AV56Sexoswwds_8_tfsexocodfor_sels ,
                                           Byte.valueOf(AV49Sexoswwds_1_tfsexoid) ,
                                           Byte.valueOf(AV50Sexoswwds_2_tfsexoid_to) ,
                                           Integer.valueOf(AV52Sexoswwds_4_tfsexonombre_sels.size()) ,
                                           AV51Sexoswwds_3_tfsexonombre ,
                                           Integer.valueOf(AV53Sexoswwds_5_tfsexobiologico_sels.size()) ,
                                           Integer.valueOf(AV54Sexoswwds_6_tfsexoidentidad_sels.size()) ,
                                           Integer.valueOf(AV56Sexoswwds_8_tfsexocodfor_sels.size()) ,
                                           AV55Sexoswwds_7_tfsexocodfor ,
                                           Byte.valueOf(A1743SexoId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV51Sexoswwds_3_tfsexonombre = GXutil.concat( GXutil.rtrim( AV51Sexoswwds_3_tfsexonombre), "%", "") ;
      lV55Sexoswwds_7_tfsexocodfor = GXutil.padr( GXutil.rtrim( AV55Sexoswwds_7_tfsexocodfor), 20, "%") ;
      /* Using cursor P01K42 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV49Sexoswwds_1_tfsexoid), Byte.valueOf(AV50Sexoswwds_2_tfsexoid_to), lV51Sexoswwds_3_tfsexonombre, lV55Sexoswwds_7_tfsexocodfor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1K42 = false ;
         A1744SexoNombre = P01K42_A1744SexoNombre[0] ;
         A2092SexoCodFor = P01K42_A2092SexoCodFor[0] ;
         A1746SexoIdentidad = P01K42_A1746SexoIdentidad[0] ;
         A1745SexoBiologico = P01K42_A1745SexoBiologico[0] ;
         n1745SexoBiologico = P01K42_n1745SexoBiologico[0] ;
         A1743SexoId = P01K42_A1743SexoId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01K42_A1744SexoNombre[0], A1744SexoNombre) == 0 ) )
         {
            brk1K42 = false ;
            A1743SexoId = P01K42_A1743SexoId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1K42 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1744SexoNombre)==0) )
         {
            AV21Option = A1744SexoNombre ;
            AV22Options.add(AV21Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1K42 )
         {
            brk1K42 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSEXOCODFOROPTIONS' Routine */
      returnInSub = false ;
      AV43TFSexoCodFor = AV33SearchTxt ;
      AV44TFSexoCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Sexoswwds_1_tfsexoid = AV11TFSexoId ;
      AV50Sexoswwds_2_tfsexoid_to = AV12TFSexoId_To ;
      AV51Sexoswwds_3_tfsexonombre = AV14TFSexoNombre ;
      AV52Sexoswwds_4_tfsexonombre_sels = AV15TFSexoNombre_Sels ;
      AV53Sexoswwds_5_tfsexobiologico_sels = AV17TFSexoBiologico_Sels ;
      AV54Sexoswwds_6_tfsexoidentidad_sels = AV19TFSexoIdentidad_Sels ;
      AV55Sexoswwds_7_tfsexocodfor = AV43TFSexoCodFor ;
      AV56Sexoswwds_8_tfsexocodfor_sels = AV44TFSexoCodFor_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1744SexoNombre ,
                                           AV52Sexoswwds_4_tfsexonombre_sels ,
                                           A1745SexoBiologico ,
                                           AV53Sexoswwds_5_tfsexobiologico_sels ,
                                           A1746SexoIdentidad ,
                                           AV54Sexoswwds_6_tfsexoidentidad_sels ,
                                           A2092SexoCodFor ,
                                           AV56Sexoswwds_8_tfsexocodfor_sels ,
                                           Byte.valueOf(AV49Sexoswwds_1_tfsexoid) ,
                                           Byte.valueOf(AV50Sexoswwds_2_tfsexoid_to) ,
                                           Integer.valueOf(AV52Sexoswwds_4_tfsexonombre_sels.size()) ,
                                           AV51Sexoswwds_3_tfsexonombre ,
                                           Integer.valueOf(AV53Sexoswwds_5_tfsexobiologico_sels.size()) ,
                                           Integer.valueOf(AV54Sexoswwds_6_tfsexoidentidad_sels.size()) ,
                                           Integer.valueOf(AV56Sexoswwds_8_tfsexocodfor_sels.size()) ,
                                           AV55Sexoswwds_7_tfsexocodfor ,
                                           Byte.valueOf(A1743SexoId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV51Sexoswwds_3_tfsexonombre = GXutil.concat( GXutil.rtrim( AV51Sexoswwds_3_tfsexonombre), "%", "") ;
      lV55Sexoswwds_7_tfsexocodfor = GXutil.padr( GXutil.rtrim( AV55Sexoswwds_7_tfsexocodfor), 20, "%") ;
      /* Using cursor P01K43 */
      pr_default.execute(1, new Object[] {Byte.valueOf(AV49Sexoswwds_1_tfsexoid), Byte.valueOf(AV50Sexoswwds_2_tfsexoid_to), lV51Sexoswwds_3_tfsexonombre, lV55Sexoswwds_7_tfsexocodfor});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1K44 = false ;
         A2092SexoCodFor = P01K43_A2092SexoCodFor[0] ;
         A1746SexoIdentidad = P01K43_A1746SexoIdentidad[0] ;
         A1745SexoBiologico = P01K43_A1745SexoBiologico[0] ;
         n1745SexoBiologico = P01K43_n1745SexoBiologico[0] ;
         A1744SexoNombre = P01K43_A1744SexoNombre[0] ;
         A1743SexoId = P01K43_A1743SexoId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01K43_A2092SexoCodFor[0], A2092SexoCodFor) == 0 ) )
         {
            brk1K44 = false ;
            A1743SexoId = P01K43_A1743SexoId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1K44 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2092SexoCodFor)==0) )
         {
            AV21Option = A2092SexoCodFor ;
            AV22Options.add(AV21Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1K44 )
         {
            brk1K44 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = sexoswwgetfilterdata.this.AV35OptionsJson;
      this.aP4[0] = sexoswwgetfilterdata.this.AV36OptionsDescJson;
      this.aP5[0] = sexoswwgetfilterdata.this.AV37OptionIndexesJson;
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
      AV14TFSexoNombre = "" ;
      AV13TFSexoNombre_SelsJson = "" ;
      AV15TFSexoNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFSexoBiologico_SelsJson = "" ;
      AV17TFSexoBiologico_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFSexoIdentidad_SelsJson = "" ;
      AV19TFSexoIdentidad_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFSexoCodFor = "" ;
      AV42TFSexoCodFor_SelsJson = "" ;
      AV44TFSexoCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A1744SexoNombre = "" ;
      AV51Sexoswwds_3_tfsexonombre = "" ;
      AV52Sexoswwds_4_tfsexonombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Sexoswwds_5_tfsexobiologico_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Sexoswwds_6_tfsexoidentidad_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Sexoswwds_7_tfsexocodfor = "" ;
      AV56Sexoswwds_8_tfsexocodfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Sexoswwds_3_tfsexonombre = "" ;
      lV55Sexoswwds_7_tfsexocodfor = "" ;
      A1745SexoBiologico = "" ;
      A1746SexoIdentidad = "" ;
      A2092SexoCodFor = "" ;
      P01K42_A1744SexoNombre = new String[] {""} ;
      P01K42_A2092SexoCodFor = new String[] {""} ;
      P01K42_A1746SexoIdentidad = new String[] {""} ;
      P01K42_A1745SexoBiologico = new String[] {""} ;
      P01K42_n1745SexoBiologico = new boolean[] {false} ;
      P01K42_A1743SexoId = new byte[1] ;
      AV21Option = "" ;
      P01K43_A2092SexoCodFor = new String[] {""} ;
      P01K43_A1746SexoIdentidad = new String[] {""} ;
      P01K43_A1745SexoBiologico = new String[] {""} ;
      P01K43_n1745SexoBiologico = new boolean[] {false} ;
      P01K43_A1744SexoNombre = new String[] {""} ;
      P01K43_A1743SexoId = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sexoswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01K42_A1744SexoNombre, P01K42_A2092SexoCodFor, P01K42_A1746SexoIdentidad, P01K42_A1745SexoBiologico, P01K42_n1745SexoBiologico, P01K42_A1743SexoId
            }
            , new Object[] {
            P01K43_A2092SexoCodFor, P01K43_A1746SexoIdentidad, P01K43_A1745SexoBiologico, P01K43_n1745SexoBiologico, P01K43_A1744SexoNombre, P01K43_A1743SexoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11TFSexoId ;
   private byte AV12TFSexoId_To ;
   private byte AV49Sexoswwds_1_tfsexoid ;
   private byte AV50Sexoswwds_2_tfsexoid_to ;
   private byte A1743SexoId ;
   private short AV39EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV40CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV52Sexoswwds_4_tfsexonombre_sels_size ;
   private int AV53Sexoswwds_5_tfsexobiologico_sels_size ;
   private int AV54Sexoswwds_6_tfsexoidentidad_sels_size ;
   private int AV56Sexoswwds_8_tfsexocodfor_sels_size ;
   private long AV26count ;
   private String AV43TFSexoCodFor ;
   private String AV55Sexoswwds_7_tfsexocodfor ;
   private String scmdbuf ;
   private String lV55Sexoswwds_7_tfsexocodfor ;
   private String A1745SexoBiologico ;
   private String A1746SexoIdentidad ;
   private String A2092SexoCodFor ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1K42 ;
   private boolean n1745SexoBiologico ;
   private boolean brk1K44 ;
   private String AV35OptionsJson ;
   private String AV36OptionsDescJson ;
   private String AV37OptionIndexesJson ;
   private String AV13TFSexoNombre_SelsJson ;
   private String AV16TFSexoBiologico_SelsJson ;
   private String AV18TFSexoIdentidad_SelsJson ;
   private String AV42TFSexoCodFor_SelsJson ;
   private String AV32DDOName ;
   private String AV33SearchTxt ;
   private String AV34SearchTxtTo ;
   private String AV14TFSexoNombre ;
   private String AV41MenuOpcCod ;
   private String A1744SexoNombre ;
   private String AV51Sexoswwds_3_tfsexonombre ;
   private String lV51Sexoswwds_3_tfsexonombre ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01K42_A1744SexoNombre ;
   private String[] P01K42_A2092SexoCodFor ;
   private String[] P01K42_A1746SexoIdentidad ;
   private String[] P01K42_A1745SexoBiologico ;
   private boolean[] P01K42_n1745SexoBiologico ;
   private byte[] P01K42_A1743SexoId ;
   private String[] P01K43_A2092SexoCodFor ;
   private String[] P01K43_A1746SexoIdentidad ;
   private String[] P01K43_A1745SexoBiologico ;
   private boolean[] P01K43_n1745SexoBiologico ;
   private String[] P01K43_A1744SexoNombre ;
   private byte[] P01K43_A1743SexoId ;
   private GXSimpleCollection<String> AV17TFSexoBiologico_Sels ;
   private GXSimpleCollection<String> AV19TFSexoIdentidad_Sels ;
   private GXSimpleCollection<String> AV44TFSexoCodFor_Sels ;
   private GXSimpleCollection<String> AV53Sexoswwds_5_tfsexobiologico_sels ;
   private GXSimpleCollection<String> AV54Sexoswwds_6_tfsexoidentidad_sels ;
   private GXSimpleCollection<String> AV56Sexoswwds_8_tfsexocodfor_sels ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV24OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private GXSimpleCollection<String> AV15TFSexoNombre_Sels ;
   private GXSimpleCollection<String> AV52Sexoswwds_4_tfsexonombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class sexoswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1744SexoNombre ,
                                          GXSimpleCollection<String> AV52Sexoswwds_4_tfsexonombre_sels ,
                                          String A1745SexoBiologico ,
                                          GXSimpleCollection<String> AV53Sexoswwds_5_tfsexobiologico_sels ,
                                          String A1746SexoIdentidad ,
                                          GXSimpleCollection<String> AV54Sexoswwds_6_tfsexoidentidad_sels ,
                                          String A2092SexoCodFor ,
                                          GXSimpleCollection<String> AV56Sexoswwds_8_tfsexocodfor_sels ,
                                          byte AV49Sexoswwds_1_tfsexoid ,
                                          byte AV50Sexoswwds_2_tfsexoid_to ,
                                          int AV52Sexoswwds_4_tfsexonombre_sels_size ,
                                          String AV51Sexoswwds_3_tfsexonombre ,
                                          int AV53Sexoswwds_5_tfsexobiologico_sels_size ,
                                          int AV54Sexoswwds_6_tfsexoidentidad_sels_size ,
                                          int AV56Sexoswwds_8_tfsexocodfor_sels_size ,
                                          String AV55Sexoswwds_7_tfsexocodfor ,
                                          byte A1743SexoId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT SexoNombre, SexoCodFor, SexoIdentidad, SexoBiologico, SexoId FROM Sexos" ;
      if ( ! (0==AV49Sexoswwds_1_tfsexoid) )
      {
         addWhere(sWhereString, "(SexoId >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV50Sexoswwds_2_tfsexoid_to) )
      {
         addWhere(sWhereString, "(SexoId <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV52Sexoswwds_4_tfsexonombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Sexoswwds_3_tfsexonombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV52Sexoswwds_4_tfsexonombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Sexoswwds_4_tfsexonombre_sels, "SexoNombre IN (", ")")+")");
      }
      if ( AV53Sexoswwds_5_tfsexobiologico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Sexoswwds_5_tfsexobiologico_sels, "SexoBiologico IN (", ")")+")");
      }
      if ( AV54Sexoswwds_6_tfsexoidentidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Sexoswwds_6_tfsexoidentidad_sels, "SexoIdentidad IN (", ")")+")");
      }
      if ( ( AV56Sexoswwds_8_tfsexocodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Sexoswwds_7_tfsexocodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV56Sexoswwds_8_tfsexocodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Sexoswwds_8_tfsexocodfor_sels, "SexoCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SexoNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01K43( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1744SexoNombre ,
                                          GXSimpleCollection<String> AV52Sexoswwds_4_tfsexonombre_sels ,
                                          String A1745SexoBiologico ,
                                          GXSimpleCollection<String> AV53Sexoswwds_5_tfsexobiologico_sels ,
                                          String A1746SexoIdentidad ,
                                          GXSimpleCollection<String> AV54Sexoswwds_6_tfsexoidentidad_sels ,
                                          String A2092SexoCodFor ,
                                          GXSimpleCollection<String> AV56Sexoswwds_8_tfsexocodfor_sels ,
                                          byte AV49Sexoswwds_1_tfsexoid ,
                                          byte AV50Sexoswwds_2_tfsexoid_to ,
                                          int AV52Sexoswwds_4_tfsexonombre_sels_size ,
                                          String AV51Sexoswwds_3_tfsexonombre ,
                                          int AV53Sexoswwds_5_tfsexobiologico_sels_size ,
                                          int AV54Sexoswwds_6_tfsexoidentidad_sels_size ,
                                          int AV56Sexoswwds_8_tfsexocodfor_sels_size ,
                                          String AV55Sexoswwds_7_tfsexocodfor ,
                                          byte A1743SexoId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SexoCodFor, SexoIdentidad, SexoBiologico, SexoNombre, SexoId FROM Sexos" ;
      if ( ! (0==AV49Sexoswwds_1_tfsexoid) )
      {
         addWhere(sWhereString, "(SexoId >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV50Sexoswwds_2_tfsexoid_to) )
      {
         addWhere(sWhereString, "(SexoId <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV52Sexoswwds_4_tfsexonombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Sexoswwds_3_tfsexonombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV52Sexoswwds_4_tfsexonombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Sexoswwds_4_tfsexonombre_sels, "SexoNombre IN (", ")")+")");
      }
      if ( AV53Sexoswwds_5_tfsexobiologico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Sexoswwds_5_tfsexobiologico_sels, "SexoBiologico IN (", ")")+")");
      }
      if ( AV54Sexoswwds_6_tfsexoidentidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Sexoswwds_6_tfsexoidentidad_sels, "SexoIdentidad IN (", ")")+")");
      }
      if ( ( AV56Sexoswwds_8_tfsexocodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Sexoswwds_7_tfsexocodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SexoCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV56Sexoswwds_8_tfsexocodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Sexoswwds_8_tfsexocodfor_sels, "SexoCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SexoCodFor" ;
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
                  return conditional_P01K42(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() );
            case 1 :
                  return conditional_P01K43(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K42", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01K43", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
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
                  stmt.setByte(sIdx, ((Number) parms[4]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[5]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[4]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[5]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

