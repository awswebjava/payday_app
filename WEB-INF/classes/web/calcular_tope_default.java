package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcular_tope_default extends GXProcedure
{
   public calcular_tope_default( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcular_tope_default.class ), "" );
   }

   public calcular_tope_default( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      calcular_tope_default.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12LiqPeriodo = localUtil.ymdtod( 2023, 12, 31) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, "1") ;
      GXv_boolean1[0] = AV26ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV8CliCod, GXv_boolean1) ;
      calcular_tope_default.this.AV26ClienteConveniador = GXv_boolean1[0] ;
      /* Using cursor P01LI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01LI2_A3CliCod[0] ;
         A1565CliConvenio = P01LI2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LI2_A1564CliPaiConve[0] ;
         if ( AV26ClienteConveniador )
         {
            AV21version_CliCod = A3CliCod ;
         }
         else
         {
            GXv_int2[0] = AV21version_CliCod ;
            new web.getversiondeconvenio(remoteHandle, context).execute( AV8CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_int2) ;
            calcular_tope_default.this.AV21version_CliCod = GXv_int2[0] ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, "2") ;
         AV9CliPaiConve = A1564CliPaiConve ;
         AV10CliConvenio = A1565CliConvenio ;
         /* Execute user subroutine: 'CATEGORIAS' */
         S121 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZAR TOPE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&CatVigencia ", "")+GXutil.trim( localUtil.dtoc( AV20CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19topeImportes)==0) )
      {
         AV31GXLvl36 = (byte)(0) ;
         /* Optimized UPDATE. */
         /* Using cursor P01LI3 */
         pr_default.execute(1, new Object[] {AV19topeImportes, Integer.valueOf(AV21version_CliCod), Short.valueOf(AV9CliPaiConve), AV10CliConvenio, AV20CatVigencia});
         if ( (pr_default.getStatus(1) != 101) )
         {
            AV31GXLvl36 = (byte)(1) ;
         }
         Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
         /* End optimized UPDATE. */
         if ( AV31GXLvl36 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&topeImportes ", "")+GXutil.trim( GXutil.str( AV19topeImportes, 14, 2))) ;
            /*
               INSERT RECORD ON TABLE clienteConvenio_importes

            */
            A3CliCod = AV21version_CliCod ;
            A1564CliPaiConve = AV9CliPaiConve ;
            A1565CliConvenio = AV10CliConvenio ;
            A1587CliConveImpVig = AV20CatVigencia ;
            A1588CliConveImpTipo = "TopeIndem" ;
            A1589CliConveImporte = AV19topeImportes ;
            A1896CliConveImpRelSec = 0 ;
            A2044CliConveImpRelRef = "" ;
            A2045CliConveImpOld = "" ;
            /* Using cursor P01LI4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte, Integer.valueOf(A1896CliConveImpRelSec), A2044CliConveImpRelRef, A2045CliConveImpOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
            if ( (pr_default.getStatus(2) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
      }
   }

   public void S121( )
   {
      /* 'CATEGORIAS' Routine */
      returnInSub = false ;
      AV16i = (short)(0) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "!&&version_CliCod ", "")+GXutil.trim( GXutil.str( AV21version_CliCod, 6, 0))+httpContext.getMessage( "&CliPaiConve ", "")+GXutil.trim( GXutil.str( AV9CliPaiConve, 4, 0))+httpContext.getMessage( " &CliConvenio ", "")+GXutil.trim( AV10CliConvenio)) ;
      AV32GXLvl65 = (byte)(0) ;
      /* Using cursor P01LI5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV21version_CliCod), Short.valueOf(AV9CliPaiConve), AV10CliConvenio});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1LI5 = false ;
         A3CliCod = P01LI5_A3CliCod[0] ;
         A1564CliPaiConve = P01LI5_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01LI5_A1565CliConvenio[0] ;
         A8CatCodigo = P01LI5_A8CatCodigo[0] ;
         A1838CatClase = P01LI5_A1838CatClase[0] ;
         A907CatVigencia = P01LI5_A907CatVigencia[0] ;
         A1838CatClase = P01LI5_A1838CatClase[0] ;
         AV32GXLvl65 = (byte)(1) ;
         AV16i = (short)(0) ;
         AV20CatVigencia = A907CatVigencia ;
         AV22maxImportes = DecimalUtil.doubleToDec(0) ;
         AV23maxCatCodigo = "" ;
         AV17TotalImportes = DecimalUtil.ZERO ;
         AV18promedioImportes = DecimalUtil.ZERO ;
         AV19topeImportes = DecimalUtil.ZERO ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, "4") ;
         while ( (pr_default.getStatus(3) != 101) && ( P01LI5_A3CliCod[0] == A3CliCod ) && ( P01LI5_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01LI5_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && GXutil.dateCompare(GXutil.resetTime(P01LI5_A907CatVigencia[0]), GXutil.resetTime(A907CatVigencia)) )
         {
            brk1LI5 = false ;
            A8CatCodigo = P01LI5_A8CatCodigo[0] ;
            A1838CatClase = P01LI5_A1838CatClase[0] ;
            A1838CatClase = P01LI5_A1838CatClase[0] ;
            AV16i = (short)(AV16i+1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, "5!") ;
            GXv_char3[0] = AV13error ;
            GXv_decimal4[0] = AV14Importes ;
            GXv_char5[0] = AV15LiqDLog ;
            new web.obtsueldobasicomensualdecategoria(remoteHandle, context).execute( A3CliCod, A1565CliConvenio, A8CatCodigo, A1838CatClase, A1564CliPaiConve, AV20CatVigencia, GXv_char3, GXv_decimal4, GXv_char5) ;
            calcular_tope_default.this.AV13error = GXv_char3[0] ;
            calcular_tope_default.this.AV14Importes = GXv_decimal4[0] ;
            calcular_tope_default.this.AV15LiqDLog = GXv_char5[0] ;
            if ( DecimalUtil.compareTo(AV14Importes, AV22maxImportes) > 0 )
            {
               AV22maxImportes = AV14Importes ;
               AV23maxCatCodigo = A8CatCodigo ;
            }
            AV17TotalImportes = AV17TotalImportes.add(AV14Importes) ;
            brk1LI5 = true ;
            pr_default.readNext(3);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV16i, 4, 0))) ;
         if ( AV16i > 0 )
         {
            AV18promedioImportes = AV17TotalImportes.divide(DecimalUtil.doubleToDec(AV16i), 18, java.math.RoundingMode.DOWN) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "maximportes ", "")+GXutil.trim( GXutil.str( AV22maxImportes, 14, 2))+httpContext.getMessage( " categoria ", "")+GXutil.trim( AV23maxCatCodigo)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( " promedio importes ", "")+GXutil.trim( GXutil.str( AV18promedioImportes, 14, 2))+httpContext.getMessage( "&TotalImportes ", "")+GXutil.trim( GXutil.str( AV17TotalImportes, 14, 2))+httpContext.getMessage( " &i ", "")+GXutil.trim( GXutil.str( AV16i, 4, 0))) ;
            AV19topeImportes = AV18promedioImportes.multiply(DecimalUtil.doubleToDec(3)) ;
            /* Execute user subroutine: 'ACTUALIZAR TOPE' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(3);
               pr_default.close(3);
               returnInSub = true;
               if (true) return;
            }
         }
         if ( ! brk1LI5 )
         {
            brk1LI5 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
      if ( AV32GXLvl65 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "nnone cat!", "")) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "calcular_tope_default");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqPeriodo = GXutil.nullDate() ;
      AV29Pgmname = "" ;
      GXv_boolean1 = new boolean[1] ;
      scmdbuf = "" ;
      P01LI2_A3CliCod = new int[1] ;
      P01LI2_A1565CliConvenio = new String[] {""} ;
      P01LI2_A1564CliPaiConve = new short[1] ;
      A1565CliConvenio = "" ;
      GXv_int2 = new int[1] ;
      AV10CliConvenio = "" ;
      A2044CliConveImpRelRef = "" ;
      A2045CliConveImpOld = "" ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      AV20CatVigencia = GXutil.nullDate() ;
      AV19topeImportes = DecimalUtil.ZERO ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      Gx_emsg = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      P01LI5_A3CliCod = new int[1] ;
      P01LI5_A1564CliPaiConve = new short[1] ;
      P01LI5_A1565CliConvenio = new String[] {""} ;
      P01LI5_A8CatCodigo = new String[] {""} ;
      P01LI5_A1838CatClase = new byte[1] ;
      P01LI5_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      A8CatCodigo = "" ;
      AV22maxImportes = DecimalUtil.ZERO ;
      AV23maxCatCodigo = "" ;
      AV17TotalImportes = DecimalUtil.ZERO ;
      AV18promedioImportes = DecimalUtil.ZERO ;
      AV13error = "" ;
      GXv_char3 = new String[1] ;
      AV14Importes = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV15LiqDLog = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calcular_tope_default__default(),
         new Object[] {
             new Object[] {
            P01LI2_A3CliCod, P01LI2_A1565CliConvenio, P01LI2_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01LI5_A3CliCod, P01LI5_A1564CliPaiConve, P01LI5_A1565CliConvenio, P01LI5_A8CatCodigo, P01LI5_A1838CatClase, P01LI5_A907CatVigencia
            }
         }
      );
      AV29Pgmname = "calcular_tope_default" ;
      /* GeneXus formulas. */
      AV29Pgmname = "calcular_tope_default" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31GXLvl36 ;
   private byte AV32GXLvl65 ;
   private byte A1838CatClase ;
   private short A1564CliPaiConve ;
   private short AV9CliPaiConve ;
   private short Gx_err ;
   private short AV16i ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int AV21version_CliCod ;
   private int GXv_int2[] ;
   private int GX_INS218 ;
   private int A1896CliConveImpRelSec ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private java.math.BigDecimal AV19topeImportes ;
   private java.math.BigDecimal AV22maxImportes ;
   private java.math.BigDecimal AV17TotalImportes ;
   private java.math.BigDecimal AV18promedioImportes ;
   private java.math.BigDecimal AV14Importes ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV29Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV10CliConvenio ;
   private String A1588CliConveImpTipo ;
   private String Gx_emsg ;
   private String A8CatCodigo ;
   private String AV23maxCatCodigo ;
   private String GXv_char3[] ;
   private String GXv_char5[] ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV20CatVigencia ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date A907CatVigencia ;
   private boolean AV26ClienteConveniador ;
   private boolean GXv_boolean1[] ;
   private boolean returnInSub ;
   private boolean brk1LI5 ;
   private String A2045CliConveImpOld ;
   private String AV15LiqDLog ;
   private String A2044CliConveImpRelRef ;
   private String AV13error ;
   private IDataStoreProvider pr_default ;
   private int[] P01LI2_A3CliCod ;
   private String[] P01LI2_A1565CliConvenio ;
   private short[] P01LI2_A1564CliPaiConve ;
   private int[] P01LI5_A3CliCod ;
   private short[] P01LI5_A1564CliPaiConve ;
   private String[] P01LI5_A1565CliConvenio ;
   private String[] P01LI5_A8CatCodigo ;
   private byte[] P01LI5_A1838CatClase ;
   private java.util.Date[] P01LI5_A907CatVigencia ;
}

final  class calcular_tope_default__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LI2", "SELECT CliCod, CliConvenio, CliPaiConve FROM ClienteConvenios WHERE CliCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01LI3", "UPDATE clienteConvenio_importes SET CliConveImporte=?  WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig = ? and CliConveImpTipo = ( 'TopeIndem')", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01LI4", "SAVEPOINT gxupdate;INSERT INTO clienteConvenio_importes(CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01LI5", "SELECT T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatCodigo, T2.CatClase, T1.CatVigencia FROM (Categoriavalores1 T1 INNER JOIN Categoria1 T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CatCodigo = T1.CatCodigo) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatVigencia ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

