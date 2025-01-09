package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletecclicencias extends GXProcedure
{
   public deletecclicencias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletecclicencias.class ), "" );
   }

   public deletecclicencias( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              short aP4 ,
                              boolean[] aP5 )
   {
      deletecclicencias.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 )
   {
      deletecclicencias.this.AV10CliCod = aP0;
      deletecclicencias.this.AV11EmpCod = aP1;
      deletecclicencias.this.AV8LegNumero = aP2;
      deletecclicencias.this.AV9LegCuenLicTpo = aP3;
      deletecclicencias.this.AV12LegCuenAnio = aP4;
      deletecclicencias.this.aP5 = aP5;
      deletecclicencias.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8LegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A2243LegCuenLicTpo ,
                                           AV9LegCuenLicTpo ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(AV12LegCuenAnio) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02BT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV9LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02BT2_A2266LegCuenAnio[0] ;
         A6LegNumero = P02BT2_A6LegNumero[0] ;
         A2243LegCuenLicTpo = P02BT2_A2243LegCuenLicTpo[0] ;
         A1EmpCod = P02BT2_A1EmpCod[0] ;
         A3CliCod = P02BT2_A3CliCod[0] ;
         A2247LegCuenDiasCorres = P02BT2_A2247LegCuenDiasCorres[0] ;
         AV16LegCuenDiasCorres = A2247LegCuenDiasCorres ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8LegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A2243LegCuenLicTpo ,
                                           AV9LegCuenLicTpo ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(AV12LegCuenAnio) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02BT3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV9LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2266LegCuenAnio = P02BT3_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02BT3_A2243LegCuenLicTpo[0] ;
         A1EmpCod = P02BT3_A1EmpCod[0] ;
         A3CliCod = P02BT3_A3CliCod[0] ;
         A6LegNumero = P02BT3_A6LegNumero[0] ;
         A2299LegCuenAntAnios = P02BT3_A2299LegCuenAntAnios[0] ;
         A2315LegCuLActVen = P02BT3_A2315LegCuLActVen[0] ;
         A2315LegCuLActVen = (short)(0) ;
         /* Using cursor P02BT4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A2327LegCuLConsOri = P02BT4_A2327LegCuLConsOri[0] ;
            A2311LegCuLConsSec = P02BT4_A2311LegCuLConsSec[0] ;
            A2312LegCuLConsCnt = P02BT4_A2312LegCuLConsCnt[0] ;
            A2310LegCuLConsAnio = P02BT4_A2310LegCuLConsAnio[0] ;
            if ( ( GXutil.strcmp(A2327LegCuLConsOri, "manual") != 0 ) && ( GXutil.strcmp(A2327LegCuLConsOri, "inicializacion") != 0 ) && ( GXutil.strcmp(A2327LegCuLConsOri, "final") != 0 ) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV23Pgmdesc, httpContext.getMessage( "delete consumo LegCuLConsSec ", "")+GXutil.trim( GXutil.str( A2311LegCuLConsSec, 4, 0))+httpContext.getMessage( " LEGNUMERO ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
               /* Using cursor P02BT5 */
               pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
            }
            else
            {
               if ( ( GXutil.strcmp(A2327LegCuLConsOri, "inicializacion") == 0 ) && ( A2312LegCuLConsCnt == AV16LegCuenDiasCorres ) )
               {
                  /* Using cursor P02BT6 */
                  pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
               }
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
         /* Using cursor P02BT7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A2326LegCuLAprLicOri = P02BT7_A2326LegCuLAprLicOri[0] ;
            A2325LegCuLAprLicCnt = P02BT7_A2325LegCuLAprLicCnt[0] ;
            A2324LegCuLAprLicFch = P02BT7_A2324LegCuLAprLicFch[0] ;
            if ( ( GXutil.strcmp(A2326LegCuLAprLicOri, "manual") != 0 ) && ( GXutil.strcmp(A2326LegCuLAprLicOri, "inicializacion") != 0 ) && ( GXutil.strcmp(A2326LegCuLAprLicOri, "final") != 0 ) )
            {
               AV15aprElimino = true ;
               /* Using cursor P02BT8 */
               pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
            }
            else
            {
               if ( GXutil.strcmp(A2326LegCuLAprLicOri, "inicializacion") == 0 )
               {
                  if ( A2325LegCuLAprLicCnt == AV16LegCuenDiasCorres )
                  {
                     /* Using cursor P02BT9 */
                     pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
                  }
                  else
                  {
                     AV17iniHay = true ;
                  }
               }
            }
            pr_default.readNext(5);
         }
         pr_default.close(5);
         /* Using cursor P02BT10 */
         pr_default.execute(8, new Object[] {Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = deletecclicencias.this.AV15aprElimino;
      this.aP6[0] = deletecclicencias.this.AV17iniHay;
      Application.commitDataStores(context, remoteHandle, pr_default, "deletecclicencias");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A2243LegCuenLicTpo = "" ;
      P02BT2_A2266LegCuenAnio = new short[1] ;
      P02BT2_A6LegNumero = new int[1] ;
      P02BT2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BT2_A1EmpCod = new short[1] ;
      P02BT2_A3CliCod = new int[1] ;
      P02BT2_A2247LegCuenDiasCorres = new short[1] ;
      P02BT3_A2266LegCuenAnio = new short[1] ;
      P02BT3_A2243LegCuenLicTpo = new String[] {""} ;
      P02BT3_A1EmpCod = new short[1] ;
      P02BT3_A3CliCod = new int[1] ;
      P02BT3_A6LegNumero = new int[1] ;
      P02BT3_A2299LegCuenAntAnios = new short[1] ;
      P02BT3_A2315LegCuLActVen = new short[1] ;
      P02BT4_A3CliCod = new int[1] ;
      P02BT4_A1EmpCod = new short[1] ;
      P02BT4_A6LegNumero = new int[1] ;
      P02BT4_A2243LegCuenLicTpo = new String[] {""} ;
      P02BT4_A2266LegCuenAnio = new short[1] ;
      P02BT4_A2327LegCuLConsOri = new String[] {""} ;
      P02BT4_A2311LegCuLConsSec = new short[1] ;
      P02BT4_A2312LegCuLConsCnt = new short[1] ;
      P02BT4_A2310LegCuLConsAnio = new short[1] ;
      A2327LegCuLConsOri = "" ;
      AV23Pgmdesc = "" ;
      P02BT7_A3CliCod = new int[1] ;
      P02BT7_A1EmpCod = new short[1] ;
      P02BT7_A6LegNumero = new int[1] ;
      P02BT7_A2243LegCuenLicTpo = new String[] {""} ;
      P02BT7_A2266LegCuenAnio = new short[1] ;
      P02BT7_A2326LegCuLAprLicOri = new String[] {""} ;
      P02BT7_A2325LegCuLAprLicCnt = new short[1] ;
      P02BT7_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      A2326LegCuLAprLicOri = "" ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletecclicencias__default(),
         new Object[] {
             new Object[] {
            P02BT2_A2266LegCuenAnio, P02BT2_A6LegNumero, P02BT2_A2243LegCuenLicTpo, P02BT2_A1EmpCod, P02BT2_A3CliCod, P02BT2_A2247LegCuenDiasCorres
            }
            , new Object[] {
            P02BT3_A2266LegCuenAnio, P02BT3_A2243LegCuenLicTpo, P02BT3_A1EmpCod, P02BT3_A3CliCod, P02BT3_A6LegNumero, P02BT3_A2299LegCuenAntAnios, P02BT3_A2315LegCuLActVen
            }
            , new Object[] {
            P02BT4_A3CliCod, P02BT4_A1EmpCod, P02BT4_A6LegNumero, P02BT4_A2243LegCuenLicTpo, P02BT4_A2266LegCuenAnio, P02BT4_A2327LegCuLConsOri, P02BT4_A2311LegCuLConsSec, P02BT4_A2312LegCuLConsCnt, P02BT4_A2310LegCuLConsAnio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P02BT7_A3CliCod, P02BT7_A1EmpCod, P02BT7_A6LegNumero, P02BT7_A2243LegCuenLicTpo, P02BT7_A2266LegCuenAnio, P02BT7_A2326LegCuLAprLicOri, P02BT7_A2325LegCuLAprLicCnt, P02BT7_A2324LegCuLAprLicFch
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV23Pgmdesc = httpContext.getMessage( "delete CCLicencias", "") ;
      /* GeneXus formulas. */
      AV23Pgmdesc = httpContext.getMessage( "delete CCLicencias", "") ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV12LegCuenAnio ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2247LegCuenDiasCorres ;
   private short AV16LegCuenDiasCorres ;
   private short A2299LegCuenAntAnios ;
   private short A2315LegCuLActVen ;
   private short A2311LegCuLConsSec ;
   private short A2312LegCuLConsCnt ;
   private short A2310LegCuLConsAnio ;
   private short A2325LegCuLAprLicCnt ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV9LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String A2327LegCuLConsOri ;
   private String AV23Pgmdesc ;
   private String A2326LegCuLAprLicOri ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private boolean AV15aprElimino ;
   private boolean AV17iniHay ;
   private boolean[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BT2_A2266LegCuenAnio ;
   private int[] P02BT2_A6LegNumero ;
   private String[] P02BT2_A2243LegCuenLicTpo ;
   private short[] P02BT2_A1EmpCod ;
   private int[] P02BT2_A3CliCod ;
   private short[] P02BT2_A2247LegCuenDiasCorres ;
   private short[] P02BT3_A2266LegCuenAnio ;
   private String[] P02BT3_A2243LegCuenLicTpo ;
   private short[] P02BT3_A1EmpCod ;
   private int[] P02BT3_A3CliCod ;
   private int[] P02BT3_A6LegNumero ;
   private short[] P02BT3_A2299LegCuenAntAnios ;
   private short[] P02BT3_A2315LegCuLActVen ;
   private int[] P02BT4_A3CliCod ;
   private short[] P02BT4_A1EmpCod ;
   private int[] P02BT4_A6LegNumero ;
   private String[] P02BT4_A2243LegCuenLicTpo ;
   private short[] P02BT4_A2266LegCuenAnio ;
   private String[] P02BT4_A2327LegCuLConsOri ;
   private short[] P02BT4_A2311LegCuLConsSec ;
   private short[] P02BT4_A2312LegCuLConsCnt ;
   private short[] P02BT4_A2310LegCuLConsAnio ;
   private int[] P02BT7_A3CliCod ;
   private short[] P02BT7_A1EmpCod ;
   private int[] P02BT7_A6LegNumero ;
   private String[] P02BT7_A2243LegCuenLicTpo ;
   private short[] P02BT7_A2266LegCuenAnio ;
   private String[] P02BT7_A2326LegCuLAprLicOri ;
   private short[] P02BT7_A2325LegCuLAprLicCnt ;
   private java.util.Date[] P02BT7_A2324LegCuLAprLicFch ;
}

final  class deletecclicencias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02BT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8LegNumero ,
                                          int A6LegNumero ,
                                          String A2243LegCuenLicTpo ,
                                          String AV9LegCuenLicTpo ,
                                          short A2266LegCuenAnio ,
                                          short AV12LegCuenAnio ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegCuenAnio, LegNumero, LegCuenLicTpo, EmpCod, CliCod, LegCuenDiasCorres FROM legajo_cuenta_licencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegCuenLicTpo = ( ?))");
      addWhere(sWhereString, "(LegCuenAnio = ?)");
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_P02BT3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8LegNumero ,
                                          int A6LegNumero ,
                                          String A2243LegCuenLicTpo ,
                                          String AV9LegCuenLicTpo ,
                                          short A2266LegCuenAnio ,
                                          short AV12LegCuenAnio ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[5];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT LegCuenAnio, LegCuenLicTpo, EmpCod, CliCod, LegNumero, LegCuenAntAnios, LegCuLActVen FROM legajo_cuenta_licencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegCuenLicTpo = ( ?))");
      addWhere(sWhereString, "(LegCuenAnio = ?)");
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int3[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF legajo_cuenta_licencias" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P02BT2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
            case 1 :
                  return conditional_P02BT3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BT3", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02BT4", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsOri, LegCuLConsSec, LegCuLConsCnt, LegCuLConsAnio FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  FOR UPDATE OF legajo_cuenta_licenciasconsumos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BT5", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BT6", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02BT7", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicOri, LegCuLAprLicCnt, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  FOR UPDATE OF legajo_cuenta_licenciasaprobaciones",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BT8", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BT9", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BT10", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuLActVen=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

