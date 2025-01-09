package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvesemhoras extends GXProcedure
{
   public getconvesemhoras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvesemhoras.class ), "" );
   }

   public getconvesemhoras( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           String aP4 ,
                                           String aP5 )
   {
      getconvesemhoras.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      getconvesemhoras.this.AV19CliCod = aP0;
      getconvesemhoras.this.AV20EmpCod = aP1;
      getconvesemhoras.this.AV21LegNumero = aP2;
      getconvesemhoras.this.AV8PaiCod = aP3;
      getconvesemhoras.this.AV9ConveCodigo = aP4;
      getconvesemhoras.this.AV23parmPaiTipoTraId = aP5;
      getconvesemhoras.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV21LegNumero, 8, 0))) ;
      if ( ! (0==AV21LegNumero) )
      {
         GXv_int1[0] = AV25CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV21LegNumero, GXv_int1) ;
         getconvesemhoras.this.AV25CliConveVer = GXv_int1[0] ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "antes ", "")) ;
         GXv_int1[0] = AV25CliConveVer ;
         new web.getversiondeconvenio(remoteHandle, context).execute( AV19CliCod, AV8PaiCod, AV9ConveCodigo, GXv_int1) ;
         getconvesemhoras.this.AV25CliConveVer = GXv_int1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "despues &CliConveVer ", "")+GXutil.trim( GXutil.str( AV25CliConveVer, 6, 0))) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&CliConveVer ", "")+GXutil.trim( GXutil.str( AV25CliConveVer, 6, 0))+httpContext.getMessage( " &PaiCod ", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))+httpContext.getMessage( " &ConveCodigo ", "")+GXutil.trim( AV9ConveCodigo)+httpContext.getMessage( " &parmPaiTipoTraId ", "")+GXutil.trim( AV23parmPaiTipoTraId)) ;
      AV29GXLvl14 = (byte)(0) ;
      /* Using cursor P01BV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV25CliConveVer), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV23parmPaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01BV2_A1294PaiTipoTraId[0] ;
         A1565CliConvenio = P01BV2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01BV2_A1564CliPaiConve[0] ;
         A3CliCod = P01BV2_A3CliCod[0] ;
         A1324ConveHsSem = P01BV2_A1324ConveHsSem[0] ;
         AV29GXLvl14 = (byte)(1) ;
         AV22ConveHsSem = A1324ConveHsSem ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&ConveHsSem ", "")+GXutil.trim( GXutil.str( AV22ConveHsSem, 4, 1))) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV29GXLvl14 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getconvesemhoras.this.AV22ConveHsSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22ConveHsSem = DecimalUtil.ZERO ;
      AV28Pgmname = "" ;
      GXv_int1 = new int[1] ;
      scmdbuf = "" ;
      P01BV2_A1294PaiTipoTraId = new String[] {""} ;
      P01BV2_A1565CliConvenio = new String[] {""} ;
      P01BV2_A1564CliPaiConve = new short[1] ;
      P01BV2_A3CliCod = new int[1] ;
      P01BV2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      A1565CliConvenio = "" ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvesemhoras__default(),
         new Object[] {
             new Object[] {
            P01BV2_A1294PaiTipoTraId, P01BV2_A1565CliConvenio, P01BV2_A1564CliPaiConve, P01BV2_A3CliCod, P01BV2_A1324ConveHsSem
            }
         }
      );
      AV28Pgmname = "getConveSemHoras" ;
      /* GeneXus formulas. */
      AV28Pgmname = "getConveSemHoras" ;
      Gx_err = (short)(0) ;
   }

   private byte AV29GXLvl14 ;
   private short AV20EmpCod ;
   private short AV8PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV21LegNumero ;
   private int AV25CliConveVer ;
   private int GXv_int1[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV22ConveHsSem ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private String AV9ConveCodigo ;
   private String AV23parmPaiTipoTraId ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A1565CliConvenio ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BV2_A1294PaiTipoTraId ;
   private String[] P01BV2_A1565CliConvenio ;
   private short[] P01BV2_A1564CliPaiConve ;
   private int[] P01BV2_A3CliCod ;
   private java.math.BigDecimal[] P01BV2_A1324ConveHsSem ;
}

final  class getconvesemhoras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BV2", "SELECT PaiTipoTraId, CliConvenio, CliPaiConve, CliCod, ConveHsSem FROM convenio_tiposdetrabajo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and PaiTipoTraId = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

