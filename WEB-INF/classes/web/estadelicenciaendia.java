package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estadelicenciaendia extends GXProcedure
{
   public estadelicenciaendia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estadelicenciaendia.class ), "" );
   }

   public estadelicenciaendia( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              java.util.Date aP6 ,
                              boolean aP7 )
   {
      estadelicenciaendia.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        boolean aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             boolean[] aP8 )
   {
      estadelicenciaendia.this.AV11CliCod = aP0;
      estadelicenciaendia.this.AV10EmpCod = aP1;
      estadelicenciaendia.this.AV9LegNumero = aP2;
      estadelicenciaendia.this.AV8LegLicSitCodigo = aP3;
      estadelicenciaendia.this.AV16LegLicenIni = aP4;
      estadelicenciaendia.this.AV15LegLicenFin = aP5;
      estadelicenciaendia.this.AV14propiaLegLicenIni = aP6;
      estadelicenciaendia.this.AV17verSoloAprobadas = aP7;
      estadelicenciaendia.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV8LegLicSitCodigo ,
                                           Boolean.valueOf(AV17verSoloAprobadas) ,
                                           A506LegLicSitCodigo ,
                                           A1497LegLicEstado ,
                                           A481LegLicenFin ,
                                           AV16LegLicenIni ,
                                           A76LegLicenIni ,
                                           AV14propiaLegLicenIni ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV9LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           AV15LegLicenFin } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE
                                           }
      });
      /* Using cursor P02CB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero), AV16LegLicenIni, AV14propiaLegLicenIni, AV15LegLicenFin, AV8LegLicSitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1497LegLicEstado = P02CB2_A1497LegLicEstado[0] ;
         A481LegLicenFin = P02CB2_A481LegLicenFin[0] ;
         A76LegLicenIni = P02CB2_A76LegLicenIni[0] ;
         A506LegLicSitCodigo = P02CB2_A506LegLicSitCodigo[0] ;
         A6LegNumero = P02CB2_A6LegNumero[0] ;
         A1EmpCod = P02CB2_A1EmpCod[0] ;
         A3CliCod = P02CB2_A3CliCod[0] ;
         AV13esta = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = estadelicenciaendia.this.AV13esta;
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
      A506LegLicSitCodigo = "" ;
      A1497LegLicEstado = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      P02CB2_A1497LegLicEstado = new String[] {""} ;
      P02CB2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P02CB2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02CB2_A506LegLicSitCodigo = new String[] {""} ;
      P02CB2_A6LegNumero = new int[1] ;
      P02CB2_A1EmpCod = new short[1] ;
      P02CB2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estadelicenciaendia__default(),
         new Object[] {
             new Object[] {
            P02CB2_A1497LegLicEstado, P02CB2_A481LegLicenFin, P02CB2_A76LegLicenIni, P02CB2_A506LegLicSitCodigo, P02CB2_A6LegNumero, P02CB2_A1EmpCod, P02CB2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV8LegLicSitCodigo ;
   private String scmdbuf ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private java.util.Date AV16LegLicenIni ;
   private java.util.Date AV15LegLicenFin ;
   private java.util.Date AV14propiaLegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV17verSoloAprobadas ;
   private boolean AV13esta ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P02CB2_A1497LegLicEstado ;
   private java.util.Date[] P02CB2_A481LegLicenFin ;
   private java.util.Date[] P02CB2_A76LegLicenIni ;
   private String[] P02CB2_A506LegLicSitCodigo ;
   private int[] P02CB2_A6LegNumero ;
   private short[] P02CB2_A1EmpCod ;
   private int[] P02CB2_A3CliCod ;
}

final  class estadelicenciaendia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV8LegLicSitCodigo ,
                                          boolean AV17verSoloAprobadas ,
                                          String A506LegLicSitCodigo ,
                                          String A1497LegLicEstado ,
                                          java.util.Date A481LegLicenFin ,
                                          java.util.Date AV16LegLicenIni ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date AV14propiaLegLicenIni ,
                                          int AV11CliCod ,
                                          short AV10EmpCod ,
                                          int AV9LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date AV15LegLicenFin )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[7];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegLicEstado, LegLicenFin, LegLicenIni, LegLicSitCodigo, LegNumero, EmpCod, CliCod FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegLicenFin >= ?)");
      addWhere(sWhereString, "(LegLicenIni <> ?)");
      addWhere(sWhereString, "(LegLicenIni <= ?)");
      if ( ! (GXutil.strcmp("", AV8LegLicSitCodigo)==0) )
      {
         addWhere(sWhereString, "(LegLicSitCodigo = ( ?))");
      }
      else
      {
         GXv_int1[6] = (byte)(1) ;
      }
      if ( AV17verSoloAprobadas )
      {
         addWhere(sWhereString, "(LegLicEstado = ( 'autorizada'))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P02CB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (java.util.Date)dynConstraints[14] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 4);
               }
               return;
      }
   }

}

