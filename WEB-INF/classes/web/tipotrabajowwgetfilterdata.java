package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipotrabajowwgetfilterdata extends GXProcedure
{
   public tipotrabajowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipotrabajowwgetfilterdata.class ), "" );
   }

   public tipotrabajowwgetfilterdata( int remoteHandle ,
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
      tipotrabajowwgetfilterdata.this.aP5 = new String[] {""};
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
      tipotrabajowwgetfilterdata.this.AV28DDOName = aP0;
      tipotrabajowwgetfilterdata.this.AV29SearchTxt = aP1;
      tipotrabajowwgetfilterdata.this.AV30SearchTxtTo = aP2;
      tipotrabajowwgetfilterdata.this.aP3 = aP3;
      tipotrabajowwgetfilterdata.this.aP4 = aP4;
      tipotrabajowwgetfilterdata.this.aP5 = aP5;
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
      tipotrabajowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipotrabajowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoTrabajo", GXv_boolean6) ;
      tipotrabajowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_TIPOTRANOM") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOTRANOMOPTIONS' */
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
      if ( GXutil.strcmp(AV23Session.getValue("TipoTrabajoWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoTrabajoWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("TipoTrabajoWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRAID_SEL") == 0 )
         {
            AV11TFTipoTraId_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFTipoTraId_Sels.fromJSonString(AV11TFTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRANOM") == 0 )
         {
            AV14TFTipoTraNom = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOTRANOM_SEL") == 0 )
         {
            AV13TFTipoTraNom_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFTipoTraNom_Sels.fromJSonString(AV13TFTipoTraNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV37MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTIPOTRANOMOPTIONS' Routine */
      returnInSub = false ;
      AV14TFTipoTraNom = AV29SearchTxt ;
      AV15TFTipoTraNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42Tipotrabajowwds_1_tftipotraid_sels = AV12TFTipoTraId_Sels ;
      AV43Tipotrabajowwds_2_tftipotranom = AV14TFTipoTraNom ;
      AV44Tipotrabajowwds_3_tftipotranom_sels = AV15TFTipoTraNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1292TipoTraId ,
                                           AV42Tipotrabajowwds_1_tftipotraid_sels ,
                                           A1293TipoTraNom ,
                                           AV44Tipotrabajowwds_3_tftipotranom_sels ,
                                           Integer.valueOf(AV42Tipotrabajowwds_1_tftipotraid_sels.size()) ,
                                           Integer.valueOf(AV44Tipotrabajowwds_3_tftipotranom_sels.size()) ,
                                           AV43Tipotrabajowwds_2_tftipotranom } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV43Tipotrabajowwds_2_tftipotranom = GXutil.concat( GXutil.rtrim( AV43Tipotrabajowwds_2_tftipotranom), "%", "") ;
      /* Using cursor P01JS2 */
      pr_default.execute(0, new Object[] {lV43Tipotrabajowwds_2_tftipotranom});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1JS2 = false ;
         A1293TipoTraNom = P01JS2_A1293TipoTraNom[0] ;
         A1292TipoTraId = P01JS2_A1292TipoTraId[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01JS2_A1293TipoTraNom[0], A1293TipoTraNom) == 0 ) )
         {
            brk1JS2 = false ;
            A1292TipoTraId = P01JS2_A1292TipoTraId[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1JS2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1293TipoTraNom)==0) )
         {
            AV17Option = A1293TipoTraNom ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JS2 )
         {
            brk1JS2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipotrabajowwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = tipotrabajowwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = tipotrabajowwgetfilterdata.this.AV33OptionIndexesJson;
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
      AV11TFTipoTraId_SelsJson = "" ;
      AV12TFTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFTipoTraNom = "" ;
      AV13TFTipoTraNom_SelsJson = "" ;
      AV15TFTipoTraNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37MenuOpcCod = "" ;
      A1293TipoTraNom = "" ;
      AV42Tipotrabajowwds_1_tftipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43Tipotrabajowwds_2_tftipotranom = "" ;
      AV44Tipotrabajowwds_3_tftipotranom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV43Tipotrabajowwds_2_tftipotranom = "" ;
      A1292TipoTraId = "" ;
      P01JS2_A1293TipoTraNom = new String[] {""} ;
      P01JS2_A1292TipoTraId = new String[] {""} ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipotrabajowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01JS2_A1293TipoTraNom, P01JS2_A1292TipoTraId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV40GXV1 ;
   private int AV42Tipotrabajowwds_1_tftipotraid_sels_size ;
   private int AV44Tipotrabajowwds_3_tftipotranom_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private String A1292TipoTraId ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1JS2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV11TFTipoTraId_SelsJson ;
   private String AV13TFTipoTraNom_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFTipoTraNom ;
   private String AV37MenuOpcCod ;
   private String A1293TipoTraNom ;
   private String AV43Tipotrabajowwds_2_tftipotranom ;
   private String lV43Tipotrabajowwds_2_tftipotranom ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JS2_A1293TipoTraNom ;
   private String[] P01JS2_A1292TipoTraId ;
   private GXSimpleCollection<String> AV12TFTipoTraId_Sels ;
   private GXSimpleCollection<String> AV42Tipotrabajowwds_1_tftipotraid_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFTipoTraNom_Sels ;
   private GXSimpleCollection<String> AV44Tipotrabajowwds_3_tftipotranom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class tipotrabajowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1292TipoTraId ,
                                          GXSimpleCollection<String> AV42Tipotrabajowwds_1_tftipotraid_sels ,
                                          String A1293TipoTraNom ,
                                          GXSimpleCollection<String> AV44Tipotrabajowwds_3_tftipotranom_sels ,
                                          int AV42Tipotrabajowwds_1_tftipotraid_sels_size ,
                                          int AV44Tipotrabajowwds_3_tftipotranom_sels_size ,
                                          String AV43Tipotrabajowwds_2_tftipotranom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( AV42Tipotrabajowwds_1_tftipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV42Tipotrabajowwds_1_tftipotraid_sels, "TipoTraId IN (", ")")+")");
      }
      if ( ( AV44Tipotrabajowwds_3_tftipotranom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Tipotrabajowwds_2_tftipotranom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV44Tipotrabajowwds_3_tftipotranom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Tipotrabajowwds_3_tftipotranom_sels, "TipoTraNom IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
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
                  return conditional_P01JS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , (String)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[1], 30);
               }
               return;
      }
   }

}

