package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlicenciavalorenrango extends GXProcedure
{
   public getlicenciavalorenrango( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlicenciavalorenrango.class ), "" );
   }

   public getlicenciavalorenrango( int remoteHandle ,
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
                              java.util.Date aP5 )
   {
      getlicenciavalorenrango.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             boolean[] aP6 )
   {
      getlicenciavalorenrango.this.AV11CliCod = aP0;
      getlicenciavalorenrango.this.AV12EmpCod = aP1;
      getlicenciavalorenrango.this.AV8LegNumero = aP2;
      getlicenciavalorenrango.this.AV19LegLicSitCodigo = aP3;
      getlicenciavalorenrango.this.AV20LegLicenFin = aP4;
      getlicenciavalorenrango.this.AV21LegLicenIni = aP5;
      getlicenciavalorenrango.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( " &LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV21LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegLicenFin ", "")+GXutil.trim( localUtil.dtoc( AV20LegLicenFin, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))) ;
      AV25GXLvl3 = (byte)(0) ;
      /* Using cursor P012N2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV8LegNumero), AV21LegLicenIni, AV20LegLicenFin});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1497LegLicEstado = P012N2_A1497LegLicEstado[0] ;
         A481LegLicenFin = P012N2_A481LegLicenFin[0] ;
         A76LegLicenIni = P012N2_A76LegLicenIni[0] ;
         A6LegNumero = P012N2_A6LegNumero[0] ;
         A1EmpCod = P012N2_A1EmpCod[0] ;
         A3CliCod = P012N2_A3CliCod[0] ;
         A517LegLicSitDescrip = P012N2_A517LegLicSitDescrip[0] ;
         A506LegLicSitCodigo = P012N2_A506LegLicSitCodigo[0] ;
         AV25GXLvl3 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( " LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( A76LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " LegLicSitCodigo ", "")+GXutil.trim( A506LegLicSitCodigo)+" \""+GXutil.trim( A517LegLicSitDescrip)+"\"") ;
         if ( !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(AV21LegLicenIni)) ) || ( GXutil.strcmp(AV19LegLicSitCodigo, A506LegLicSitCodigo) != 0 ) )
         {
            AV17existe = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getlicenciavalorenrango.this.AV17existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24Pgmname = "" ;
      scmdbuf = "" ;
      P012N2_A1497LegLicEstado = new String[] {""} ;
      P012N2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P012N2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P012N2_A6LegNumero = new int[1] ;
      P012N2_A1EmpCod = new short[1] ;
      P012N2_A3CliCod = new int[1] ;
      P012N2_A517LegLicSitDescrip = new String[] {""} ;
      P012N2_A506LegLicSitCodigo = new String[] {""} ;
      A1497LegLicEstado = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      A517LegLicSitDescrip = "" ;
      A506LegLicSitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlicenciavalorenrango__default(),
         new Object[] {
             new Object[] {
            P012N2_A1497LegLicEstado, P012N2_A481LegLicenFin, P012N2_A76LegLicenIni, P012N2_A6LegNumero, P012N2_A1EmpCod, P012N2_A3CliCod, P012N2_A517LegLicSitDescrip, P012N2_A506LegLicSitCodigo
            }
         }
      );
      AV24Pgmname = "GetLicenciaValorEnRango" ;
      /* GeneXus formulas. */
      AV24Pgmname = "GetLicenciaValorEnRango" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl3 ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV19LegLicSitCodigo ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A1497LegLicEstado ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV20LegLicenFin ;
   private java.util.Date AV21LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV17existe ;
   private String A517LegLicSitDescrip ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P012N2_A1497LegLicEstado ;
   private java.util.Date[] P012N2_A481LegLicenFin ;
   private java.util.Date[] P012N2_A76LegLicenIni ;
   private int[] P012N2_A6LegNumero ;
   private short[] P012N2_A1EmpCod ;
   private int[] P012N2_A3CliCod ;
   private String[] P012N2_A517LegLicSitDescrip ;
   private String[] P012N2_A506LegLicSitCodigo ;
}

final  class getlicenciavalorenrango__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012N2", "SELECT LegLicEstado, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitDescrip, LegLicSitCodigo FROM LegajoLicencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegLicenFin >= ? or (LegLicenFin = DATE '00010101') or LegLicenFin IS NULL) AND (LegLicEstado = ( 'autorizada')) AND (LegLicenIni <= ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 4);
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

