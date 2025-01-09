package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultimasituacionlegajo extends GXProcedure
{
   public getultimasituacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultimasituacionlegajo.class ), "" );
   }

   public getultimasituacionlegajo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String[] aP4 )
   {
      getultimasituacionlegajo.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getultimasituacionlegajo.this.AV9CliCod = aP0;
      getultimasituacionlegajo.this.AV10EmpCod = aP1;
      getultimasituacionlegajo.this.AV11LegNumero = aP2;
      getultimasituacionlegajo.this.AV12LiqPeriodo = aP3;
      getultimasituacionlegajo.this.aP4 = aP4;
      getultimasituacionlegajo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "1") ;
      AV8SitCodigo = "" ;
      /* Using cursor P012M2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV12LiqPeriodo, AV12LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A506LegLicSitCodigo = P012M2_A506LegLicSitCodigo[0] ;
         A3CliCod = P012M2_A3CliCod[0] ;
         A1EmpCod = P012M2_A1EmpCod[0] ;
         A6LegNumero = P012M2_A6LegNumero[0] ;
         A1289LegSitEsAfip = P012M2_A1289LegSitEsAfip[0] ;
         A1497LegLicEstado = P012M2_A1497LegLicEstado[0] ;
         A481LegLicenFin = P012M2_A481LegLicenFin[0] ;
         A76LegLicenIni = P012M2_A76LegLicenIni[0] ;
         A1598EstadoSitRevista = P012M2_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P012M2_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = P012M2_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P012M2_n1600EstadoSiniestro[0] ;
         A1598EstadoSitRevista = P012M2_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P012M2_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = P012M2_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P012M2_n1600EstadoSiniestro[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "2") ;
         AV8SitCodigo = GXutil.trim( GXutil.str( A1598EstadoSitRevista, 3, 0)) ;
         AV14SinieCodigo = A1600EstadoSiniestro ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "3") ;
      if ( (GXutil.strcmp("", AV8SitCodigo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, "4") ;
         AV8SitCodigo = "01" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getultimasituacionlegajo.this.AV8SitCodigo;
      this.aP5[0] = getultimasituacionlegajo.this.AV14SinieCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SitCodigo = "" ;
      AV14SinieCodigo = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P012M2_A506LegLicSitCodigo = new String[] {""} ;
      P012M2_A3CliCod = new int[1] ;
      P012M2_A1EmpCod = new short[1] ;
      P012M2_A6LegNumero = new int[1] ;
      P012M2_A1289LegSitEsAfip = new byte[1] ;
      P012M2_A1497LegLicEstado = new String[] {""} ;
      P012M2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P012M2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P012M2_A1598EstadoSitRevista = new short[1] ;
      P012M2_n1598EstadoSitRevista = new boolean[] {false} ;
      P012M2_A1600EstadoSiniestro = new String[] {""} ;
      P012M2_n1600EstadoSiniestro = new boolean[] {false} ;
      A506LegLicSitCodigo = "" ;
      A1497LegLicEstado = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      A1600EstadoSiniestro = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultimasituacionlegajo__default(),
         new Object[] {
             new Object[] {
            P012M2_A506LegLicSitCodigo, P012M2_A3CliCod, P012M2_A1EmpCod, P012M2_A6LegNumero, P012M2_A1289LegSitEsAfip, P012M2_A1497LegLicEstado, P012M2_A481LegLicenFin, P012M2_A76LegLicenIni, P012M2_A1598EstadoSitRevista, P012M2_n1598EstadoSitRevista,
            P012M2_A1600EstadoSiniestro, P012M2_n1600EstadoSiniestro
            }
         }
      );
      AV17Pgmname = "getUltimaSituacionLegajo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getUltimaSituacionLegajo" ;
      Gx_err = (short)(0) ;
   }

   private byte A1289LegSitEsAfip ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short A1598EstadoSitRevista ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV8SitCodigo ;
   private String AV14SinieCodigo ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private String A1600EstadoSiniestro ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean n1598EstadoSitRevista ;
   private boolean n1600EstadoSiniestro ;
   private String[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P012M2_A506LegLicSitCodigo ;
   private int[] P012M2_A3CliCod ;
   private short[] P012M2_A1EmpCod ;
   private int[] P012M2_A6LegNumero ;
   private byte[] P012M2_A1289LegSitEsAfip ;
   private String[] P012M2_A1497LegLicEstado ;
   private java.util.Date[] P012M2_A481LegLicenFin ;
   private java.util.Date[] P012M2_A76LegLicenIni ;
   private short[] P012M2_A1598EstadoSitRevista ;
   private boolean[] P012M2_n1598EstadoSitRevista ;
   private String[] P012M2_A1600EstadoSiniestro ;
   private boolean[] P012M2_n1600EstadoSiniestro ;
}

final  class getultimasituacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012M2", "SELECT T1.LegLicSitCodigo AS LegLicSitCodigo, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegSitEsAfip, T1.LegLicEstado, T1.LegLicenFin, T1.LegLicenIni, T2.EstadoSitRevista, T2.EstadoSiniestro FROM (LegajoLicencias T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.LegLicSitCodigo) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegLicenIni <= ?) AND ((T1.LegLicenFin = DATE '00010101') or T1.LegLicenFin IS NULL or T1.LegLicenFin >= ?) AND (T1.LegSitEsAfip = 1) AND (T1.LegLicEstado = ( 'autorizada')) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegLicenIni DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(10, 4);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

