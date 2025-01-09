package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getescalasalarialvigente3 extends GXProcedure
{
   public getescalasalarialvigente3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getescalasalarialvigente3.class ), "" );
   }

   public getescalasalarialvigente3( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           String aP2 ,
                                           String aP3 ,
                                           java.util.Date aP4 ,
                                           byte aP5 ,
                                           String aP6 ,
                                           boolean[] aP7 ,
                                           String[] aP8 )
   {
      getescalasalarialvigente3.this.aP9 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        byte aP5 ,
                        String aP6 ,
                        boolean[] aP7 ,
                        String[] aP8 ,
                        java.math.BigDecimal[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             byte aP5 ,
                             String aP6 ,
                             boolean[] aP7 ,
                             String[] aP8 ,
                             java.math.BigDecimal[] aP9 )
   {
      getescalasalarialvigente3.this.AV19CliConveVer = aP0;
      getescalasalarialvigente3.this.AV15PaiCod = aP1;
      getescalasalarialvigente3.this.AV9ConveCodigo = aP2;
      getescalasalarialvigente3.this.AV8CatCodigo = aP3;
      getescalasalarialvigente3.this.AV13CatVigencia = aP4;
      getescalasalarialvigente3.this.AV11LegClase = aP5;
      getescalasalarialvigente3.this.AV10que = aP6;
      getescalasalarialvigente3.this.aP7 = aP7;
      getescalasalarialvigente3.this.aP8 = aP8;
      getescalasalarialvigente3.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "!!&PaiCod ", "")+GXutil.trim( GXutil.str( AV15PaiCod, 4, 0))+httpContext.getMessage( " &ConveCodigo ", "")+GXutil.trim( AV9ConveCodigo)+httpContext.getMessage( " &CliConveVer ", "")+GXutil.trim( GXutil.str( AV19CliConveVer, 6, 0))+httpContext.getMessage( " &CatCodigo ", "")+GXutil.trim( AV8CatCodigo)+httpContext.getMessage( " &CatVigencia ", "")+GXutil.trim( localUtil.dtoc( AV13CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV36GXLvl7 = (byte)(0) ;
      /* Using cursor P01R02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliConveVer), Short.valueOf(AV15PaiCod), AV9ConveCodigo, AV8CatCodigo, AV13CatVigencia});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01R02_A3CliCod[0] ;
         A1564CliPaiConve = P01R02_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01R02_A1565CliConvenio[0] ;
         A8CatCodigo = P01R02_A8CatCodigo[0] ;
         A907CatVigencia = P01R02_A907CatVigencia[0] ;
         A1892EscBasico = P01R02_A1892EscBasico[0] ;
         A1893EscAdicional = P01R02_A1893EscAdicional[0] ;
         AV36GXLvl7 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "entra ", "")+AV10que) ;
         if ( GXutil.strcmp(AV10que, httpContext.getMessage( "BASICO", "")) == 0 )
         {
            AV12Importes = A1892EscBasico ;
         }
         else
         {
            if ( GXutil.strcmp(AV10que, httpContext.getMessage( "ADICIONAL", "")) == 0 )
            {
               AV12Importes = A1893EscAdicional ;
            }
            else
            {
               if ( GXutil.strcmp(AV10que, httpContext.getMessage( "TOTAL", "")) == 0 )
               {
                  AV12Importes = A1892EscBasico.add(A1893EscAdicional) ;
               }
            }
         }
         AV24ult_CatVigencia = A907CatVigencia ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl7 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "none", "")) ;
         GXv_char1[0] = AV32ConveDescri ;
         GXv_boolean2[0] = false ;
         new web.getconvenio(remoteHandle, context).execute( AV16CliCod, AV9ConveCodigo, GXv_char1, GXv_boolean2) ;
         getescalasalarialvigente3.this.AV32ConveDescri = GXv_char1[0] ;
         AV18error = httpContext.getMessage( "No existe escala salarial vigente para la categoría ", "") + GXutil.trim( AV8CatCodigo) + httpContext.getMessage( ", de convenio ", "") + GXutil.trim( AV32ConveDescri) + httpContext.getMessage( ". Fecha de vigencia ", "") + GXutil.trim( localUtil.dtoc( AV13CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      GXt_boolean3 = AV25CliConveActObl ;
      GXv_boolean2[0] = GXt_boolean3 ;
      new web.getcliconveactobl(remoteHandle, context).execute( AV19CliConveVer, AV15PaiCod, AV9ConveCodigo, GXv_boolean2) ;
      getescalasalarialvigente3.this.GXt_boolean3 = GXv_boolean2[0] ;
      AV25CliConveActObl = GXt_boolean3 ;
      if ( AV25CliConveActObl )
      {
         GXv_boolean2[0] = AV26actualizadaEsta ;
         GXv_char1[0] = AV30auxError ;
         new web.escalasalarialactualizada(remoteHandle, context).execute( AV19CliConveVer, AV15PaiCod, AV9ConveCodigo, AV8CatCodigo, AV28ult_OpeCliVig, AV13CatVigencia, GXv_boolean2, GXv_char1) ;
         getescalasalarialvigente3.this.AV26actualizadaEsta = GXv_boolean2[0] ;
         getescalasalarialvigente3.this.AV30auxError = GXv_char1[0] ;
         if ( ! (GXutil.strcmp("", AV30auxError)==0) )
         {
            AV18error = AV30auxError ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! AV26actualizadaEsta )
         {
            GXv_char1[0] = AV27CatDescrip ;
            new web.getcategoria2(remoteHandle, context).execute( AV19CliConveVer, AV15PaiCod, AV9ConveCodigo, AV8CatCodigo, GXv_char1) ;
            getescalasalarialvigente3.this.AV27CatDescrip = GXv_char1[0] ;
            GXt_char4 = AV29periodoTexto ;
            GXv_char1[0] = GXt_char4 ;
            new web.armaperpalabra(remoteHandle, context).execute( AV16CliCod, AV13CatVigencia, GXv_char1) ;
            getescalasalarialvigente3.this.GXt_char4 = GXv_char1[0] ;
            AV29periodoTexto = GXt_char4 ;
            AV18error = httpContext.getMessage( "La escala salarial para la categoría ", "") + GXutil.trim( AV27CatDescrip) + httpContext.getMessage( " en el periodo ", "") + AV29periodoTexto + httpContext.getMessage( " no está actualizada", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      GXv_char1[0] = AV31CatTipoTarifa ;
      new web.gettipotarifacat(remoteHandle, context).execute( AV19CliConveVer, AV15PaiCod, AV9ConveCodigo, AV8CatCodigo, GXv_char1) ;
      getescalasalarialvigente3.this.AV31CatTipoTarifa = GXv_char1[0] ;
      if ( GXutil.strcmp(AV31CatTipoTarifa, "H") == 0 )
      {
         AV17devuelveValorHora = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getescalasalarialvigente3.this.AV17devuelveValorHora;
      this.aP8[0] = getescalasalarialvigente3.this.AV18error;
      this.aP9[0] = getescalasalarialvigente3.this.AV12Importes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18error = "" ;
      AV12Importes = DecimalUtil.ZERO ;
      AV35Pgmname = "" ;
      scmdbuf = "" ;
      P01R02_A3CliCod = new int[1] ;
      P01R02_A1564CliPaiConve = new short[1] ;
      P01R02_A1565CliConvenio = new String[] {""} ;
      P01R02_A8CatCodigo = new String[] {""} ;
      P01R02_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01R02_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01R02_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      AV24ult_CatVigencia = GXutil.nullDate() ;
      AV32ConveDescri = "" ;
      AV28ult_OpeCliVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV30auxError = "" ;
      AV27CatDescrip = "" ;
      AV29periodoTexto = "" ;
      GXt_char4 = "" ;
      AV31CatTipoTarifa = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getescalasalarialvigente3__default(),
         new Object[] {
             new Object[] {
            P01R02_A3CliCod, P01R02_A1564CliPaiConve, P01R02_A1565CliConvenio, P01R02_A8CatCodigo, P01R02_A907CatVigencia, P01R02_A1892EscBasico, P01R02_A1893EscAdicional
            }
         }
      );
      AV35Pgmname = "GetEscalaSalarialVigente3" ;
      /* GeneXus formulas. */
      AV35Pgmname = "GetEscalaSalarialVigente3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LegClase ;
   private byte AV36GXLvl7 ;
   private short AV15PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV19CliConveVer ;
   private int A3CliCod ;
   private int AV16CliCod ;
   private java.math.BigDecimal AV12Importes ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private String AV9ConveCodigo ;
   private String AV8CatCodigo ;
   private String AV10que ;
   private String AV35Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String GXt_char4 ;
   private String AV31CatTipoTarifa ;
   private String GXv_char1[] ;
   private java.util.Date AV13CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date AV24ult_CatVigencia ;
   private java.util.Date AV28ult_OpeCliVig ;
   private boolean AV17devuelveValorHora ;
   private boolean AV25CliConveActObl ;
   private boolean GXt_boolean3 ;
   private boolean AV26actualizadaEsta ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV18error ;
   private String AV32ConveDescri ;
   private String AV30auxError ;
   private String AV27CatDescrip ;
   private String AV29periodoTexto ;
   private java.math.BigDecimal[] aP9 ;
   private boolean[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01R02_A3CliCod ;
   private short[] P01R02_A1564CliPaiConve ;
   private String[] P01R02_A1565CliConvenio ;
   private String[] P01R02_A8CatCodigo ;
   private java.util.Date[] P01R02_A907CatVigencia ;
   private java.math.BigDecimal[] P01R02_A1892EscBasico ;
   private java.math.BigDecimal[] P01R02_A1893EscAdicional ;
}

final  class getescalasalarialvigente3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R02", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, EscAdicional FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia <= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
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
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

