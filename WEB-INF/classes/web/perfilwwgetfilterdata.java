package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class perfilwwgetfilterdata extends GXProcedure
{
   public perfilwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( perfilwwgetfilterdata.class ), "" );
   }

   public perfilwwgetfilterdata( int remoteHandle ,
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
      perfilwwgetfilterdata.this.aP5 = new String[] {""};
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
      perfilwwgetfilterdata.this.AV28DDOName = aP0;
      perfilwwgetfilterdata.this.AV29SearchTxt = aP1;
      perfilwwgetfilterdata.this.AV30SearchTxtTo = aP2;
      perfilwwgetfilterdata.this.aP3 = aP3;
      perfilwwgetfilterdata.this.aP4 = aP4;
      perfilwwgetfilterdata.this.aP5 = aP5;
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
      perfilwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      perfilwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPerfil", GXv_boolean6) ;
      perfilwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PERFILNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADPERFILNOMBREOPTIONS' */
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
      if ( GXutil.strcmp(AV23Session.getValue("PerfilWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PerfilWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("PerfilWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILID") == 0 )
         {
            AV11TFPerfilId = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPerfilId_To = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE") == 0 )
         {
            AV14TFPerfilNombre = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERFILNOMBRE_SEL") == 0 )
         {
            AV13TFPerfilNombre_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFPerfilNombre_Sels.fromJSonString(AV13TFPerfilNombre_SelsJson, null);
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
      /* 'LOADPERFILNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV14TFPerfilNombre = AV29SearchTxt ;
      AV15TFPerfilNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42Perfilwwds_1_tfperfilid = AV11TFPerfilId ;
      AV43Perfilwwds_2_tfperfilid_to = AV12TFPerfilId_To ;
      AV44Perfilwwds_3_tfperfilnombre = AV14TFPerfilNombre ;
      AV45Perfilwwds_4_tfperfilnombre_sels = AV15TFPerfilNombre_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1926PerfilNombre ,
                                           AV45Perfilwwds_4_tfperfilnombre_sels ,
                                           Byte.valueOf(AV42Perfilwwds_1_tfperfilid) ,
                                           Byte.valueOf(AV43Perfilwwds_2_tfperfilid_to) ,
                                           Integer.valueOf(AV45Perfilwwds_4_tfperfilnombre_sels.size()) ,
                                           AV44Perfilwwds_3_tfperfilnombre ,
                                           Byte.valueOf(A1925PerfilId) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT
                                           }
      });
      lV44Perfilwwds_3_tfperfilnombre = GXutil.concat( GXutil.rtrim( AV44Perfilwwds_3_tfperfilnombre), "%", "") ;
      /* Using cursor P01UM2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV42Perfilwwds_1_tfperfilid), Byte.valueOf(AV43Perfilwwds_2_tfperfilid_to), lV44Perfilwwds_3_tfperfilnombre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1UM2 = false ;
         A1926PerfilNombre = P01UM2_A1926PerfilNombre[0] ;
         A1925PerfilId = P01UM2_A1925PerfilId[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01UM2_A1926PerfilNombre[0], A1926PerfilNombre) == 0 ) )
         {
            brk1UM2 = false ;
            A1925PerfilId = P01UM2_A1925PerfilId[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1UM2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1926PerfilNombre)==0) )
         {
            AV17Option = A1926PerfilNombre ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UM2 )
         {
            brk1UM2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = perfilwwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = perfilwwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = perfilwwgetfilterdata.this.AV33OptionIndexesJson;
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
      AV14TFPerfilNombre = "" ;
      AV13TFPerfilNombre_SelsJson = "" ;
      AV15TFPerfilNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37MenuOpcCod = "" ;
      A1926PerfilNombre = "" ;
      AV44Perfilwwds_3_tfperfilnombre = "" ;
      AV45Perfilwwds_4_tfperfilnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Perfilwwds_3_tfperfilnombre = "" ;
      P01UM2_A1926PerfilNombre = new String[] {""} ;
      P01UM2_A1925PerfilId = new byte[1] ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.perfilwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01UM2_A1926PerfilNombre, P01UM2_A1925PerfilId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11TFPerfilId ;
   private byte AV12TFPerfilId_To ;
   private byte AV42Perfilwwds_1_tfperfilid ;
   private byte AV43Perfilwwds_2_tfperfilid_to ;
   private byte A1925PerfilId ;
   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV40GXV1 ;
   private int AV45Perfilwwds_4_tfperfilnombre_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1UM2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFPerfilNombre_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFPerfilNombre ;
   private String AV37MenuOpcCod ;
   private String A1926PerfilNombre ;
   private String AV44Perfilwwds_3_tfperfilnombre ;
   private String lV44Perfilwwds_3_tfperfilnombre ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UM2_A1926PerfilNombre ;
   private byte[] P01UM2_A1925PerfilId ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFPerfilNombre_Sels ;
   private GXSimpleCollection<String> AV45Perfilwwds_4_tfperfilnombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class perfilwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1926PerfilNombre ,
                                          GXSimpleCollection<String> AV45Perfilwwds_4_tfperfilnombre_sels ,
                                          byte AV42Perfilwwds_1_tfperfilid ,
                                          byte AV43Perfilwwds_2_tfperfilid_to ,
                                          int AV45Perfilwwds_4_tfperfilnombre_sels_size ,
                                          String AV44Perfilwwds_3_tfperfilnombre ,
                                          byte A1925PerfilId ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PerfilNombre, PerfilId FROM Perfil" ;
      if ( ! (0==AV42Perfilwwds_1_tfperfilid) )
      {
         addWhere(sWhereString, "(PerfilId >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV43Perfilwwds_2_tfperfilid_to) )
      {
         addWhere(sWhereString, "(PerfilId <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV45Perfilwwds_4_tfperfilnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Perfilwwds_3_tfperfilnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PerfilNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV45Perfilwwds_4_tfperfilnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Perfilwwds_4_tfperfilnombre_sels, "PerfilNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PerfilNombre" ;
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
                  return conditional_P01UM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[8]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
                  stmt.setByte(sIdx, ((Number) parms[3]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[4]).byteValue());
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

