package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_feriadowwgetfilterdata extends GXProcedure
{
   public tipo_feriadowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_feriadowwgetfilterdata.class ), "" );
   }

   public tipo_feriadowwgetfilterdata( int remoteHandle ,
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
      tipo_feriadowwgetfilterdata.this.aP5 = new String[] {""};
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
      tipo_feriadowwgetfilterdata.this.AV28DDOName = aP0;
      tipo_feriadowwgetfilterdata.this.AV29SearchTxt = aP1;
      tipo_feriadowwgetfilterdata.this.AV30SearchTxtTo = aP2;
      tipo_feriadowwgetfilterdata.this.aP3 = aP3;
      tipo_feriadowwgetfilterdata.this.aP4 = aP4;
      tipo_feriadowwgetfilterdata.this.aP5 = aP5;
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
      tipo_feriadowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipo_feriadowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_feriado", GXv_boolean6) ;
      tipo_feriadowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_FERTIPODESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADFERTIPODESCRIPOPTIONS' */
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
      if ( GXutil.strcmp(AV23Session.getValue("tipo_feriadoWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "tipo_feriadoWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("tipo_feriadoWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERTIPO_SEL") == 0 )
         {
            AV11TFFerTipo_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFFerTipo_Sels.fromJSonString(AV11TFFerTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERTIPODESCRIP") == 0 )
         {
            AV14TFFerTipoDescrip = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERTIPODESCRIP_SEL") == 0 )
         {
            AV13TFFerTipoDescrip_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFFerTipoDescrip_Sels.fromJSonString(AV13TFFerTipoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADFERTIPODESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFFerTipoDescrip = AV29SearchTxt ;
      AV15TFFerTipoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Tipo_feriadowwds_1_tffertipo_sels = AV12TFFerTipo_Sels ;
      AV44Tipo_feriadowwds_2_tffertipodescrip = AV14TFFerTipoDescrip ;
      AV45Tipo_feriadowwds_3_tffertipodescrip_sels = AV15TFFerTipoDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1221FerTipo ,
                                           AV43Tipo_feriadowwds_1_tffertipo_sels ,
                                           A1785FerTipoDescrip ,
                                           AV45Tipo_feriadowwds_3_tffertipodescrip_sels ,
                                           Integer.valueOf(AV43Tipo_feriadowwds_1_tffertipo_sels.size()) ,
                                           Integer.valueOf(AV45Tipo_feriadowwds_3_tffertipodescrip_sels.size()) ,
                                           AV44Tipo_feriadowwds_2_tffertipodescrip ,
                                           Short.valueOf(AV37PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV44Tipo_feriadowwds_2_tffertipodescrip = GXutil.concat( GXutil.rtrim( AV44Tipo_feriadowwds_2_tffertipodescrip), "%", "") ;
      /* Using cursor P01MO2 */
      pr_default.execute(0, new Object[] {lV44Tipo_feriadowwds_2_tffertipodescrip, Short.valueOf(AV37PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1MO2 = false ;
         A1785FerTipoDescrip = P01MO2_A1785FerTipoDescrip[0] ;
         A46PaiCod = P01MO2_A46PaiCod[0] ;
         A1221FerTipo = P01MO2_A1221FerTipo[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01MO2_A1785FerTipoDescrip[0], A1785FerTipoDescrip) == 0 ) )
         {
            brk1MO2 = false ;
            A46PaiCod = P01MO2_A46PaiCod[0] ;
            A1221FerTipo = P01MO2_A1221FerTipo[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1MO2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1785FerTipoDescrip)==0) )
         {
            AV17Option = A1785FerTipoDescrip ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1MO2 )
         {
            brk1MO2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipo_feriadowwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = tipo_feriadowwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = tipo_feriadowwgetfilterdata.this.AV33OptionIndexesJson;
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
      AV11TFFerTipo_SelsJson = "" ;
      AV12TFFerTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFFerTipoDescrip = "" ;
      AV13TFFerTipoDescrip_SelsJson = "" ;
      AV15TFFerTipoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A1785FerTipoDescrip = "" ;
      AV43Tipo_feriadowwds_1_tffertipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44Tipo_feriadowwds_2_tffertipodescrip = "" ;
      AV45Tipo_feriadowwds_3_tffertipodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Tipo_feriadowwds_2_tffertipodescrip = "" ;
      A1221FerTipo = "" ;
      P01MO2_A1785FerTipoDescrip = new String[] {""} ;
      P01MO2_A46PaiCod = new short[1] ;
      P01MO2_A1221FerTipo = new String[] {""} ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_feriadowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01MO2_A1785FerTipoDescrip, P01MO2_A46PaiCod, P01MO2_A1221FerTipo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV37PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV43Tipo_feriadowwds_1_tffertipo_sels_size ;
   private int AV45Tipo_feriadowwds_3_tffertipodescrip_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private String A1221FerTipo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1MO2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV11TFFerTipo_SelsJson ;
   private String AV13TFFerTipoDescrip_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFFerTipoDescrip ;
   private String AV38MenuOpcCod ;
   private String A1785FerTipoDescrip ;
   private String AV44Tipo_feriadowwds_2_tffertipodescrip ;
   private String lV44Tipo_feriadowwds_2_tffertipodescrip ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MO2_A1785FerTipoDescrip ;
   private short[] P01MO2_A46PaiCod ;
   private String[] P01MO2_A1221FerTipo ;
   private GXSimpleCollection<String> AV12TFFerTipo_Sels ;
   private GXSimpleCollection<String> AV43Tipo_feriadowwds_1_tffertipo_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFFerTipoDescrip_Sels ;
   private GXSimpleCollection<String> AV45Tipo_feriadowwds_3_tffertipodescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class tipo_feriadowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01MO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1221FerTipo ,
                                          GXSimpleCollection<String> AV43Tipo_feriadowwds_1_tffertipo_sels ,
                                          String A1785FerTipoDescrip ,
                                          GXSimpleCollection<String> AV45Tipo_feriadowwds_3_tffertipodescrip_sels ,
                                          int AV43Tipo_feriadowwds_1_tffertipo_sels_size ,
                                          int AV45Tipo_feriadowwds_3_tffertipodescrip_sels_size ,
                                          String AV44Tipo_feriadowwds_2_tffertipodescrip ,
                                          short AV37PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT FerTipoDescrip, PaiCod, FerTipo FROM tipo_feriado" ;
      if ( AV43Tipo_feriadowwds_1_tffertipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV43Tipo_feriadowwds_1_tffertipo_sels, "FerTipo IN (", ")")+")");
      }
      if ( ( AV45Tipo_feriadowwds_3_tffertipodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Tipo_feriadowwds_2_tffertipodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerTipoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV45Tipo_feriadowwds_3_tffertipodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Tipo_feriadowwds_3_tffertipodescrip_sels, "FerTipoDescrip IN (", ")")+")");
      }
      if ( ! (0==AV37PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY FerTipoDescrip" ;
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
                  return conditional_P01MO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[2], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               return;
      }
   }

}

