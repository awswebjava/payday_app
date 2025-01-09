package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituacionesrevistaparalsd extends GXProcedure
{
   public getsituacionesrevistaparalsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituacionesrevistaparalsd.class ), "" );
   }

   public getsituacionesrevistaparalsd( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             GXSimpleCollection<String>[] aP5 )
   {
      getsituacionesrevistaparalsd.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        GXSimpleCollection<String>[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             GXSimpleCollection<String>[] aP5 ,
                             String[] aP6 )
   {
      getsituacionesrevistaparalsd.this.AV8CliCod = aP0;
      getsituacionesrevistaparalsd.this.AV9EmpCod = aP1;
      getsituacionesrevistaparalsd.this.AV10LegNumero = aP2;
      getsituacionesrevistaparalsd.this.AV11LiqPeriodo = aP3;
      getsituacionesrevistaparalsd.this.aP4 = aP4;
      getsituacionesrevistaparalsd.this.aP5 = aP5;
      getsituacionesrevistaparalsd.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13situaciones.clear();
      AV14fechas.clear();
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "1") ;
      /* Using cursor P012L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P012L2_A6LegNumero[0] ;
         A1EmpCod = P012L2_A1EmpCod[0] ;
         A3CliCod = P012L2_A3CliCod[0] ;
         A1603LegSitRevEgreso = P012L2_A1603LegSitRevEgreso[0] ;
         n1603LegSitRevEgreso = P012L2_n1603LegSitRevEgreso[0] ;
         if ( ! (0==A1603LegSitRevEgreso) )
         {
            AV12SitCodigo = GXutil.trim( GXutil.str( A1603LegSitRevEgreso, 3, 0)) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "2") ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "3") ;
      if ( (GXutil.strcmp("", AV12SitCodigo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "4") ;
         GXv_char1[0] = AV12SitCodigo ;
         GXv_char2[0] = AV20SinieCodigo ;
         new web.getultimasituacionlegajo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV11LiqPeriodo, GXv_char1, GXv_char2) ;
         getsituacionesrevistaparalsd.this.AV12SitCodigo = GXv_char1[0] ;
         getsituacionesrevistaparalsd.this.AV20SinieCodigo = GXv_char2[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "5 &SitCodigo ", "")+AV12SitCodigo) ;
      AV13situaciones.add(AV12SitCodigo, 0);
      AV14fechas.add("01", 0);
      AV18fin.add(AV11LiqPeriodo, 0);
      /* Using cursor P012L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LiqPeriodo, AV11LiqPeriodo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1289LegSitEsAfip = P012L3_A1289LegSitEsAfip[0] ;
         A1497LegLicEstado = P012L3_A1497LegLicEstado[0] ;
         A76LegLicenIni = P012L3_A76LegLicenIni[0] ;
         A6LegNumero = P012L3_A6LegNumero[0] ;
         A1EmpCod = P012L3_A1EmpCod[0] ;
         A3CliCod = P012L3_A3CliCod[0] ;
         A506LegLicSitCodigo = P012L3_A506LegLicSitCodigo[0] ;
         A481LegLicenFin = P012L3_A481LegLicenFin[0] ;
         AV13situaciones.add(GXutil.padl( GXutil.trim( A506LegLicSitCodigo), (short)(2), "0"), 0);
         AV14fechas.add(GXutil.padl( GXutil.str( GXutil.day( A76LegLicenIni), 10, 0), (short)(2), "0"), 0);
         AV18fin.add(A481LegLicenFin, 0);
         AV17i = (short)(AV17i+1) ;
         if ( AV17i == 2 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV13situaciones.size() == 1 )
      {
         AV13situaciones.add("  ", 0);
         AV14fechas.add("00", 0);
         AV13situaciones.add("  ", 0);
         AV14fechas.add("00", 0);
      }
      else
      {
         if ( AV13situaciones.size() == 2 )
         {
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime((java.util.Date)AV18fin.elementAt(-1+2))) && GXutil.resetTime((java.util.Date)AV18fin.elementAt(-1+2)).before( GXutil.resetTime( GXutil.eomdate( AV11LiqPeriodo) )) )
            {
               AV13situaciones.add("01", 0);
               AV19auxFecha = GXutil.dadd((java.util.Date)AV18fin.elementAt(-1+2),+(1)) ;
               AV14fechas.add(GXutil.padl( GXutil.str( GXutil.day( AV19auxFecha), 10, 0), (short)(2), "0"), 0);
            }
            else
            {
               AV13situaciones.add("  ", 0);
               AV14fechas.add("00", 0);
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getsituacionesrevistaparalsd.this.AV13situaciones;
      this.aP5[0] = getsituacionesrevistaparalsd.this.AV14fechas;
      this.aP6[0] = getsituacionesrevistaparalsd.this.AV20SinieCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13situaciones = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14fechas = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20SinieCodigo = "" ;
      AV23Pgmname = "" ;
      scmdbuf = "" ;
      P012L2_A6LegNumero = new int[1] ;
      P012L2_A1EmpCod = new short[1] ;
      P012L2_A3CliCod = new int[1] ;
      P012L2_A1603LegSitRevEgreso = new short[1] ;
      P012L2_n1603LegSitRevEgreso = new boolean[] {false} ;
      AV12SitCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV18fin = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      P012L3_A1289LegSitEsAfip = new byte[1] ;
      P012L3_A1497LegLicEstado = new String[] {""} ;
      P012L3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P012L3_A6LegNumero = new int[1] ;
      P012L3_A1EmpCod = new short[1] ;
      P012L3_A3CliCod = new int[1] ;
      P012L3_A506LegLicSitCodigo = new String[] {""} ;
      P012L3_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      AV19auxFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituacionesrevistaparalsd__default(),
         new Object[] {
             new Object[] {
            P012L2_A6LegNumero, P012L2_A1EmpCod, P012L2_A3CliCod, P012L2_A1603LegSitRevEgreso, P012L2_n1603LegSitRevEgreso
            }
            , new Object[] {
            P012L3_A1289LegSitEsAfip, P012L3_A1497LegLicEstado, P012L3_A76LegLicenIni, P012L3_A6LegNumero, P012L3_A1EmpCod, P012L3_A3CliCod, P012L3_A506LegLicSitCodigo, P012L3_A481LegLicenFin
            }
         }
      );
      AV23Pgmname = "getSituacionesRevistaParaLSD" ;
      /* GeneXus formulas. */
      AV23Pgmname = "getSituacionesRevistaParaLSD" ;
      Gx_err = (short)(0) ;
   }

   private byte A1289LegSitEsAfip ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A1603LegSitRevEgreso ;
   private short AV17i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV20SinieCodigo ;
   private String AV23Pgmname ;
   private String scmdbuf ;
   private String AV12SitCodigo ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String A1497LegLicEstado ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date AV19auxFecha ;
   private boolean n1603LegSitRevEgreso ;
   private String[] aP6 ;
   private GXSimpleCollection<String>[] aP4 ;
   private GXSimpleCollection<String>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P012L2_A6LegNumero ;
   private short[] P012L2_A1EmpCod ;
   private int[] P012L2_A3CliCod ;
   private short[] P012L2_A1603LegSitRevEgreso ;
   private boolean[] P012L2_n1603LegSitRevEgreso ;
   private byte[] P012L3_A1289LegSitEsAfip ;
   private String[] P012L3_A1497LegLicEstado ;
   private java.util.Date[] P012L3_A76LegLicenIni ;
   private int[] P012L3_A6LegNumero ;
   private short[] P012L3_A1EmpCod ;
   private int[] P012L3_A3CliCod ;
   private String[] P012L3_A506LegLicSitCodigo ;
   private java.util.Date[] P012L3_A481LegLicenFin ;
   private GXSimpleCollection<String> AV13situaciones ;
   private GXSimpleCollection<String> AV14fechas ;
   private GXSimpleCollection<java.util.Date> AV18fin ;
}

final  class getsituacionesrevistaparalsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012L2", "SELECT LegNumero, EmpCod, CliCod, LegSitRevEgreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P012L3", "SELECT LegSitEsAfip, LegLicEstado, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitCodigo, LegLicenFin FROM LegajoLicencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegLicenIni > ?) AND (LegLicenIni <= (CAST(DATE_TRUNC('MONTH',CAST(? AS date)) + '1 MONTH'::INTERVAL AS DATE ) - 1)) AND (LegLicEstado = ( 'autorizada')) AND (LegSitEsAfip = 1) ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 4);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

