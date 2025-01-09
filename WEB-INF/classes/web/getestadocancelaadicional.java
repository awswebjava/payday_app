package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadocancelaadicional extends GXProcedure
{
   public getestadocancelaadicional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadocancelaadicional.class ), "" );
   }

   public getestadocancelaadicional( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             boolean[] aP9 )
   {
      getestadocancelaadicional.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        short aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        java.util.Date aP8 ,
                        boolean[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 )
   {
      getestadocancelaadicional.this.AV19CliCod = aP0;
      getestadocancelaadicional.this.AV8CliConveVer = aP1;
      getestadocancelaadicional.this.AV13EmpCod = aP2;
      getestadocancelaadicional.this.AV14LegNumero = aP3;
      getestadocancelaadicional.this.AV9PaiCod = aP4;
      getestadocancelaadicional.this.AV10ConveCodigo = aP5;
      getestadocancelaadicional.this.AV11ConveAdicod = aP6;
      getestadocancelaadicional.this.AV21desdeFecha = aP7;
      getestadocancelaadicional.this.AV20hastaFecha = aP8;
      getestadocancelaadicional.this.aP9 = aP9;
      getestadocancelaadicional.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01P42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliConveVer), Short.valueOf(AV9PaiCod), AV10ConveCodigo, AV11ConveAdicod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A996ConveAdicod = P01P42_A996ConveAdicod[0] ;
         A1565CliConvenio = P01P42_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01P42_A1564CliPaiConve[0] ;
         A3CliCod = P01P42_A3CliCod[0] ;
         A1824ConveAdiSitCancela = P01P42_A1824ConveAdiSitCancela[0] ;
         AV12cancelanSitCodigo.add(A1824ConveAdiSitCancela, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A506LegLicSitCodigo ,
                                           AV12cancelanSitCodigo ,
                                           A481LegLicenFin ,
                                           AV21desdeFecha ,
                                           A1497LegLicEstado ,
                                           Integer.valueOf(AV19CliCod) ,
                                           Short.valueOf(AV13EmpCod) ,
                                           Integer.valueOf(AV14LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A76LegLicenIni ,
                                           AV20hastaFecha } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P01P43 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV19CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV14LegNumero), AV21desdeFecha, AV20hastaFecha});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1497LegLicEstado = P01P43_A1497LegLicEstado[0] ;
         A506LegLicSitCodigo = P01P43_A506LegLicSitCodigo[0] ;
         A481LegLicenFin = P01P43_A481LegLicenFin[0] ;
         A76LegLicenIni = P01P43_A76LegLicenIni[0] ;
         A6LegNumero = P01P43_A6LegNumero[0] ;
         A1EmpCod = P01P43_A1EmpCod[0] ;
         A3CliCod = P01P43_A3CliCod[0] ;
         A517LegLicSitDescrip = P01P43_A517LegLicSitDescrip[0] ;
         AV17seCancela = true ;
         AV18liqdlog = httpContext.getMessage( "La licencia \"", "") + GXutil.trim( A517LegLicSitDescrip) + httpContext.getMessage( "\" del ", "") + GXutil.trim( localUtil.dtoc( A76LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " cancela ", "") + GXutil.trim( AV11ConveAdicod) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getestadocancelaadicional.this.AV17seCancela;
      this.aP10[0] = getestadocancelaadicional.this.AV18liqdlog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18liqdlog = "" ;
      scmdbuf = "" ;
      P01P42_A996ConveAdicod = new String[] {""} ;
      P01P42_A1565CliConvenio = new String[] {""} ;
      P01P42_A1564CliPaiConve = new short[1] ;
      P01P42_A3CliCod = new int[1] ;
      P01P42_A1824ConveAdiSitCancela = new String[] {""} ;
      A996ConveAdicod = "" ;
      A1565CliConvenio = "" ;
      A1824ConveAdiSitCancela = "" ;
      AV12cancelanSitCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      A506LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      P01P43_A1497LegLicEstado = new String[] {""} ;
      P01P43_A506LegLicSitCodigo = new String[] {""} ;
      P01P43_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01P43_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01P43_A6LegNumero = new int[1] ;
      P01P43_A1EmpCod = new short[1] ;
      P01P43_A3CliCod = new int[1] ;
      P01P43_A517LegLicSitDescrip = new String[] {""} ;
      A517LegLicSitDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadocancelaadicional__default(),
         new Object[] {
             new Object[] {
            P01P42_A996ConveAdicod, P01P42_A1565CliConvenio, P01P42_A1564CliPaiConve, P01P42_A3CliCod, P01P42_A1824ConveAdiSitCancela
            }
            , new Object[] {
            P01P43_A1497LegLicEstado, P01P43_A506LegLicSitCodigo, P01P43_A481LegLicenFin, P01P43_A76LegLicenIni, P01P43_A6LegNumero, P01P43_A1EmpCod, P01P43_A3CliCod, P01P43_A517LegLicSitDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV9PaiCod ;
   private short A1564CliPaiConve ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV8CliConveVer ;
   private int AV14LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV10ConveCodigo ;
   private String AV11ConveAdicod ;
   private String scmdbuf ;
   private String A996ConveAdicod ;
   private String A1565CliConvenio ;
   private String A1824ConveAdiSitCancela ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private java.util.Date AV21desdeFecha ;
   private java.util.Date AV20hastaFecha ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV17seCancela ;
   private String AV18liqdlog ;
   private String A517LegLicSitDescrip ;
   private String[] aP10 ;
   private boolean[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01P42_A996ConveAdicod ;
   private String[] P01P42_A1565CliConvenio ;
   private short[] P01P42_A1564CliPaiConve ;
   private int[] P01P42_A3CliCod ;
   private String[] P01P42_A1824ConveAdiSitCancela ;
   private String[] P01P43_A1497LegLicEstado ;
   private String[] P01P43_A506LegLicSitCodigo ;
   private java.util.Date[] P01P43_A481LegLicenFin ;
   private java.util.Date[] P01P43_A76LegLicenIni ;
   private int[] P01P43_A6LegNumero ;
   private short[] P01P43_A1EmpCod ;
   private int[] P01P43_A3CliCod ;
   private String[] P01P43_A517LegLicSitDescrip ;
   private GXSimpleCollection<String> AV12cancelanSitCodigo ;
}

final  class getestadocancelaadicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01P43( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A506LegLicSitCodigo ,
                                          GXSimpleCollection<String> AV12cancelanSitCodigo ,
                                          java.util.Date A481LegLicenFin ,
                                          java.util.Date AV21desdeFecha ,
                                          String A1497LegLicEstado ,
                                          int AV19CliCod ,
                                          short AV13EmpCod ,
                                          int AV14LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date AV20hastaFecha )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegLicEstado, LegLicSitCodigo, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitDescrip FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegLicenFin >= ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV12cancelanSitCodigo, "LegLicSitCodigo IN (", ")")+")");
      addWhere(sWhereString, "(LegLicEstado = ( 'autorizada'))");
      addWhere(sWhereString, "(LegLicenIni <= ?)");
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
            case 1 :
                  return conditional_P01P43(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01P42", "SELECT ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01P43", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               return;
      }
   }

}

