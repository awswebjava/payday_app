package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class finlotepdf extends GXProcedure
{
   public finlotepdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( finlotepdf.class ), "" );
   }

   public finlotepdf( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        GXSimpleCollection<Integer> aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             GXSimpleCollection<Integer> aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 )
   {
      finlotepdf.this.AV8CliCod = aP0;
      finlotepdf.this.AV9EmpCod = aP1;
      finlotepdf.this.AV13LiqNro = aP2;
      finlotepdf.this.AV16LiqLote = aP3;
      finlotepdf.this.AV12LegNumero = aP4;
      finlotepdf.this.AV14tipoRecibo = aP5;
      finlotepdf.this.AV10error = aP6;
      finlotepdf.this.AV17imprimirLiqLegPalabra = aP7;
      finlotepdf.this.AV19daemonUUID = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "hola", "")) ;
      AV11i = (short)(1) ;
      if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV17imprimirLiqLegPalabra)), httpContext.getMessage( "MASIVO", "")) == 0 )
      {
         while ( AV11i <= AV12LegNumero.size() )
         {
            if ( ! (GXutil.strcmp("", AV10error)==0) )
            {
               new web.liqgrabarutapdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LiqNro, ((Number) AV12LegNumero.elementAt(-1+AV11i)).intValue(), AV14tipoRecibo, "", "") ;
            }
            else
            {
               GXt_char1 = AV15nombresPDFs ;
               GXv_char2[0] = GXt_char1 ;
               new web.nombrearchivorecibo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LiqNro, ((Number) AV12LegNumero.elementAt(-1+AV11i)).intValue(), AV14tipoRecibo, httpContext.getMessage( "pdf", ""), "", GXv_char2) ;
               finlotepdf.this.GXt_char1 = GXv_char2[0] ;
               AV15nombresPDFs = GXt_char1 ;
               new web.liqgrabarutapdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LiqNro, ((Number) AV12LegNumero.elementAt(-1+AV11i)).intValue(), AV14tipoRecibo, "", AV15nombresPDFs) ;
            }
            AV11i = (short)(AV11i+1) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "que tal", "")) ;
      GXv_int3[0] = AV18LiqBatchEtapa ;
      new web.getloteetapa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, (int)(DecimalUtil.decToDouble(AV23Liqnr)), AV16LiqLote, httpContext.getMessage( "GENERACION_PDFS", ""), GXv_int3) ;
      finlotepdf.this.AV18LiqBatchEtapa = GXv_int3[0] ;
      if ( AV18LiqBatchEtapa != 2 )
      {
         new web.grabaliquidacionlote(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LiqNro, AV16LiqLote, httpContext.getMessage( "GENERACION_PDFS", ""), (short)(2), AV10error, AV12LegNumero, AV19daemonUUID) ;
      }
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
      AV22Pgmname = "" ;
      AV15nombresPDFs = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV23Liqnr = DecimalUtil.ZERO ;
      GXv_int3 = new short[1] ;
      AV22Pgmname = "finLotePDF" ;
      /* GeneXus formulas. */
      AV22Pgmname = "finLotePDF" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11i ;
   private short AV18LiqBatchEtapa ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13LiqNro ;
   private java.math.BigDecimal AV23Liqnr ;
   private String AV14tipoRecibo ;
   private String AV17imprimirLiqLegPalabra ;
   private String AV19daemonUUID ;
   private String AV22Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV16LiqLote ;
   private String AV10error ;
   private String AV15nombresPDFs ;
   private GXSimpleCollection<Integer> AV12LegNumero ;
}

