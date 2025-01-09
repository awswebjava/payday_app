package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horaswcgetfilterdata extends GXProcedure
{
   public horaswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horaswcgetfilterdata.class ), "" );
   }

   public horaswcgetfilterdata( int remoteHandle ,
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
      horaswcgetfilterdata.this.aP5 = new String[] {""};
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
      horaswcgetfilterdata.this.AV26DDOName = aP0;
      horaswcgetfilterdata.this.AV27SearchTxt = aP1;
      horaswcgetfilterdata.this.AV28SearchTxtTo = aP2;
      horaswcgetfilterdata.this.aP3 = aP3;
      horaswcgetfilterdata.this.aP4 = aP4;
      horaswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades", GXv_boolean2) ;
      horaswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_TIPOCONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOCONDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV29OptionsJson = AV16Options.toJSonString(false) ;
      AV30OptionsDescJson = AV18OptionsDesc.toJSonString(false) ;
      AV31OptionIndexesJson = AV19OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("horasWCGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "horasWCGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("horasWCGridState"), null, null);
      }
      AV38GXV1 = 1 ;
      while ( AV38GXV1 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV38GXV1));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP") == 0 )
         {
            AV12TFTipoConDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP_SEL") == 0 )
         {
            AV11TFTipoConDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFTipoConDescrip_Sels.fromJSonString(AV11TFTipoConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV32CliCod = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV33EmpCod = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV35LegNumero = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV38GXV1 = (int)(AV38GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTIPOCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFTipoConDescrip = AV27SearchTxt ;
      AV13TFTipoConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A370TipoConDescrip ,
                                           AV13TFTipoConDescrip_Sels ,
                                           Integer.valueOf(AV13TFTipoConDescrip_Sels.size()) ,
                                           AV12TFTipoConDescrip ,
                                           Integer.valueOf(AV32CliCod) ,
                                           Short.valueOf(AV33EmpCod) ,
                                           Integer.valueOf(AV35LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV12TFTipoConDescrip = GXutil.concat( GXutil.rtrim( AV12TFTipoConDescrip), "%", "") ;
      /* Using cursor P01QM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV33EmpCod), Integer.valueOf(AV35LegNumero), lV12TFTipoConDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1QM2 = false ;
         A26ConCodigo = P01QM2_A26ConCodigo[0] ;
         A37TipoConCod = P01QM2_A37TipoConCod[0] ;
         A3CliCod = P01QM2_A3CliCod[0] ;
         A1EmpCod = P01QM2_A1EmpCod[0] ;
         A6LegNumero = P01QM2_A6LegNumero[0] ;
         A370TipoConDescrip = P01QM2_A370TipoConDescrip[0] ;
         A25AgeOrden = P01QM2_A25AgeOrden[0] ;
         A37TipoConCod = P01QM2_A37TipoConCod[0] ;
         A370TipoConDescrip = P01QM2_A370TipoConDescrip[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01QM2_A3CliCod[0] == A3CliCod ) && ( P01QM2_A1EmpCod[0] == A1EmpCod ) && ( P01QM2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QM2_A370TipoConDescrip[0], A370TipoConDescrip) == 0 ) )
         {
            brk1QM2 = false ;
            A26ConCodigo = P01QM2_A26ConCodigo[0] ;
            A37TipoConCod = P01QM2_A37TipoConCod[0] ;
            A25AgeOrden = P01QM2_A25AgeOrden[0] ;
            A37TipoConCod = P01QM2_A37TipoConCod[0] ;
            AV20count = (long)(AV20count+1) ;
            brk1QM2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A370TipoConDescrip)==0) )
         {
            AV15Option = A370TipoConDescrip ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QM2 )
         {
            brk1QM2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = horaswcgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = horaswcgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = horaswcgetfilterdata.this.AV31OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV31OptionIndexesJson = "" ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFTipoConDescrip = "" ;
      AV11TFTipoConDescrip_SelsJson = "" ;
      AV13TFTipoConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV12TFTipoConDescrip = "" ;
      A370TipoConDescrip = "" ;
      P01QM2_A26ConCodigo = new String[] {""} ;
      P01QM2_A37TipoConCod = new String[] {""} ;
      P01QM2_A3CliCod = new int[1] ;
      P01QM2_A1EmpCod = new short[1] ;
      P01QM2_A6LegNumero = new int[1] ;
      P01QM2_A370TipoConDescrip = new String[] {""} ;
      P01QM2_A25AgeOrden = new short[1] ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      AV15Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.horaswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01QM2_A26ConCodigo, P01QM2_A37TipoConCod, P01QM2_A3CliCod, P01QM2_A1EmpCod, P01QM2_A6LegNumero, P01QM2_A370TipoConDescrip, P01QM2_A25AgeOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV38GXV1 ;
   private int AV32CliCod ;
   private int AV35LegNumero ;
   private int AV13TFTipoConDescrip_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV20count ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1QM2 ;
   private String AV29OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV31OptionIndexesJson ;
   private String AV11TFTipoConDescrip_SelsJson ;
   private String AV26DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV12TFTipoConDescrip ;
   private String lV12TFTipoConDescrip ;
   private String A370TipoConDescrip ;
   private String AV15Option ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01QM2_A26ConCodigo ;
   private String[] P01QM2_A37TipoConCod ;
   private int[] P01QM2_A3CliCod ;
   private short[] P01QM2_A1EmpCod ;
   private int[] P01QM2_A6LegNumero ;
   private String[] P01QM2_A370TipoConDescrip ;
   private short[] P01QM2_A25AgeOrden ;
   private GXSimpleCollection<String> AV16Options ;
   private GXSimpleCollection<String> AV18OptionsDesc ;
   private GXSimpleCollection<String> AV19OptionIndexes ;
   private GXSimpleCollection<String> AV13TFTipoConDescrip_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
}

final  class horaswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01QM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A370TipoConDescrip ,
                                          GXSimpleCollection<String> AV13TFTipoConDescrip_Sels ,
                                          int AV13TFTipoConDescrip_Sels_size ,
                                          String AV12TFTipoConDescrip ,
                                          int AV32CliCod ,
                                          short AV33EmpCod ,
                                          int AV35LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.ConCodigo, T2.TipoConCod, T1.CliCod, T1.EmpCod, T1.LegNumero, T3.TipoConDescrip, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Concepto T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) INNER JOIN TipoDeConcepto T3 ON T3.TipoConCod = T2.TipoConCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ( AV13TFTipoConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFTipoConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV13TFTipoConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFTipoConDescrip_Sels, "T3.TipoConDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.TipoConDescrip" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01QM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01QM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               return;
      }
   }

}

