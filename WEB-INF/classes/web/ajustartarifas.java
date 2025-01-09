package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustartarifas extends GXProcedure
{
   public ajustartarifas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustartarifas.class ), "" );
   }

   public ajustartarifas( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             int aP7 )
   {
      ajustartarifas.this.AV9CliCod = aP0;
      ajustartarifas.this.AV10CliPaiConve = aP1;
      ajustartarifas.this.AV11CliConvenio = aP2;
      ajustartarifas.this.AV17origenCatVigencia = aP3;
      ajustartarifas.this.AV18porUnaje = aP4;
      ajustartarifas.this.AV13CatVigencia = aP5;
      ajustartarifas.this.AV21que = aP6;
      ajustartarifas.this.AV24CliRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01JE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10CliPaiConve), AV11CliConvenio, AV17origenCatVigencia});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A907CatVigencia = P01JE2_A907CatVigencia[0] ;
         A1565CliConvenio = P01JE2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01JE2_A1564CliPaiConve[0] ;
         A3CliCod = P01JE2_A3CliCod[0] ;
         A1892EscBasico = P01JE2_A1892EscBasico[0] ;
         A1893EscAdicional = P01JE2_A1893EscAdicional[0] ;
         A8CatCodigo = P01JE2_A8CatCodigo[0] ;
         if ( GXutil.strcmp(AV21que, httpContext.getMessage( "Truncar", "")) == 0 )
         {
            AV23EscBasico = GXutil.truncDecimal( A1892EscBasico.multiply(AV18porUnaje), 0) ;
            AV22EscAdicional = GXutil.truncDecimal( A1893EscAdicional.multiply(AV18porUnaje), 0) ;
         }
         else
         {
            if ( GXutil.strcmp(AV21que, httpContext.getMessage( "Redondear", "")) == 0 )
            {
               AV23EscBasico = GXutil.roundDecimal( A1892EscBasico.multiply(AV18porUnaje), 0) ;
               AV22EscAdicional = GXutil.roundDecimal( A1893EscAdicional.multiply(AV18porUnaje), 0) ;
            }
            else
            {
               if ( GXutil.strcmp(AV21que, httpContext.getMessage( "RedondearUp", "")) == 0 )
               {
                  AV23EscBasico = GXutil.roundToEven( A1892EscBasico.multiply(AV18porUnaje), 0) ;
                  AV22EscAdicional = GXutil.roundToEven( A1893EscAdicional.multiply(AV18porUnaje), 0) ;
               }
               else
               {
                  if ( GXutil.strcmp(AV21que, httpContext.getMessage( "RedondearArriba", "")) == 0 )
                  {
                     AV25auxImportes = A1892EscBasico.multiply(AV18porUnaje) ;
                     AV26trunc = (long)(DecimalUtil.decToDouble(GXutil.truncDecimal( AV25auxImportes, 0))) ;
                     AV27parteDecimal = AV31Aux.subtract(DecimalUtil.doubleToDec(AV26trunc)) ;
                     if ( AV27parteDecimal.doubleValue() > 0 )
                     {
                        AV23EscBasico = DecimalUtil.doubleToDec(AV26trunc+1) ;
                     }
                     else
                     {
                        AV23EscBasico = DecimalUtil.doubleToDec(AV26trunc) ;
                     }
                     AV25auxImportes = A1893EscAdicional.multiply(AV18porUnaje) ;
                     AV26trunc = (long)(DecimalUtil.decToDouble(GXutil.truncDecimal( AV25auxImportes, 0))) ;
                     AV27parteDecimal = AV31Aux.subtract(DecimalUtil.doubleToDec(AV26trunc)) ;
                     if ( AV27parteDecimal.doubleValue() > 0 )
                     {
                        AV23EscBasico = DecimalUtil.doubleToDec(AV26trunc+1) ;
                     }
                     else
                     {
                        AV23EscBasico = DecimalUtil.doubleToDec(AV26trunc) ;
                     }
                  }
                  else
                  {
                     AV23EscBasico = A1892EscBasico.multiply(AV18porUnaje) ;
                     AV22EscAdicional = A1893EscAdicional.multiply(AV18porUnaje) ;
                  }
               }
            }
         }
         AV12CatCodigo = A8CatCodigo ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&CliConvenio ", "")+AV11CliConvenio+httpContext.getMessage( " catcodigo ", "")+AV12CatCodigo+httpContext.getMessage( " &vig ", "")+GXutil.trim( localUtil.dtoc( AV13CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &EscBasico ", "")+GXutil.trim( GXutil.str( AV23EscBasico, 14, 2))+httpContext.getMessage( "&EscAdicional ", "")+GXutil.trim( GXutil.str( AV22EscAdicional, 14, 2))) ;
         new web.newescalasalarial(remoteHandle, context).execute( AV9CliCod, AV10CliPaiConve, AV11CliConvenio, AV12CatCodigo, AV13CatVigencia, AV23EscBasico, AV22EscAdicional, AV24CliRelSec) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "termina", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
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
      P01JE2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01JE2_A1565CliConvenio = new String[] {""} ;
      P01JE2_A1564CliPaiConve = new short[1] ;
      P01JE2_A3CliCod = new int[1] ;
      P01JE2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JE2_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JE2_A8CatCodigo = new String[] {""} ;
      A907CatVigencia = GXutil.nullDate() ;
      A1565CliConvenio = "" ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      A8CatCodigo = "" ;
      AV23EscBasico = DecimalUtil.ZERO ;
      AV22EscAdicional = DecimalUtil.ZERO ;
      AV25auxImportes = DecimalUtil.ZERO ;
      AV27parteDecimal = DecimalUtil.ZERO ;
      AV31Aux = DecimalUtil.ZERO ;
      AV12CatCodigo = "" ;
      AV32Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustartarifas__default(),
         new Object[] {
             new Object[] {
            P01JE2_A907CatVigencia, P01JE2_A1565CliConvenio, P01JE2_A1564CliPaiConve, P01JE2_A3CliCod, P01JE2_A1892EscBasico, P01JE2_A1893EscAdicional, P01JE2_A8CatCodigo
            }
         }
      );
      AV32Pgmname = "ajustarTarifas" ;
      /* GeneXus formulas. */
      AV32Pgmname = "ajustarTarifas" ;
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV24CliRelSec ;
   private int A3CliCod ;
   private long AV26trunc ;
   private java.math.BigDecimal AV18porUnaje ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal AV23EscBasico ;
   private java.math.BigDecimal AV22EscAdicional ;
   private java.math.BigDecimal AV25auxImportes ;
   private java.math.BigDecimal AV27parteDecimal ;
   private java.math.BigDecimal AV31Aux ;
   private String AV11CliConvenio ;
   private String AV21que ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV12CatCodigo ;
   private String AV32Pgmname ;
   private java.util.Date AV17origenCatVigencia ;
   private java.util.Date AV13CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01JE2_A907CatVigencia ;
   private String[] P01JE2_A1565CliConvenio ;
   private short[] P01JE2_A1564CliPaiConve ;
   private int[] P01JE2_A3CliCod ;
   private java.math.BigDecimal[] P01JE2_A1892EscBasico ;
   private java.math.BigDecimal[] P01JE2_A1893EscAdicional ;
   private String[] P01JE2_A8CatCodigo ;
}

final  class ajustartarifas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JE2", "SELECT CatVigencia, CliConvenio, CliPaiConve, CliCod, EscBasico, EscAdicional, CatCodigo FROM Categoriavalores1 WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (CatVigencia = ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

