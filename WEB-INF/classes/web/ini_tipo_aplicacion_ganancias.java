package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_tipo_aplicacion_ganancias extends GXProcedure
{
   public ini_tipo_aplicacion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_tipo_aplicacion_ganancias.class ), "" );
   }

   public ini_tipo_aplicacion_ganancias( int remoteHandle ,
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
      ini_tipo_aplicacion_ganancias.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9AplIIGG = (short)(0) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Totalmente gravado", ""), DecimalUtil.doubleToDec(1), (byte)(3), "", "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV15AplIIGGNom = httpContext.getMessage( "Exento / Sin tope", "") ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.doubleToDec(1), AV10TipoTope, "", "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Horas extras extras de feriados y fines de semana", ""), DecimalUtil.doubleToDec(1), AV10TipoTope, "", "", "", "", "", DecimalUtil.doubleToDec(0), (byte)(1), (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "SAC", ""), DecimalUtil.doubleToDec(1), AV10TipoTope, "", "", "", "", "", DecimalUtil.doubleToDec(0), (byte)(2), (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      AV15AplIIGGNom = httpContext.getMessage( "Tope 1 MNI", "") ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.doubleToDec(1), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      AV15AplIIGGNom = httpContext.getMessage( "Tope 40% de MNI", "") ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.stringToDec("0.4"), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      AV15AplIIGGNom = httpContext.getMessage( "Tope MNI x 4", "") ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.doubleToDec(4), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      GXt_char1 = AV16CondExenIIGG ;
      GXv_char2[0] = GXt_char1 ;
      new web.getcondiiggbonos(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char2[0] ;
      AV16CondExenIIGG = GXt_char1 ;
      AV15AplIIGGNom = httpContext.getMessage( "Bonos 1 - Tope 40% de MNI - Condicionado por sueldo bruto", "") ;
      GXt_char1 = AV17AplIIGGExenCon ;
      GXt_char3 = AV17AplIIGGExenCon ;
      GXv_char2[0] = GXt_char3 ;
      new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      AV17AplIIGGExenCon = GXt_char1 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.stringToDec("0.4"), (byte)(1), AV12palabra, "", AV16CondExenIIGG, AV17AplIIGGExenCon, "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(1)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      AV15AplIIGGNom = httpContext.getMessage( "Fallo de caja - Tope 40% de MNI", "") ;
      GXt_char3 = AV17AplIIGGExenCon ;
      GXt_char1 = AV17AplIIGGExenCon ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_falloscajaexentos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV17AplIIGGExenCon = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.stringToDec("0.4"), (byte)(1), AV12palabra, "", AV16CondExenIIGG, AV17AplIIGGExenCon, "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(1)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[mni]" ;
      AV15AplIIGGNom = httpContext.getMessage( "Similar naturaleza - Tope 40% de MNI", "") ;
      GXt_char3 = AV17AplIIGGExenCon ;
      GXt_char1 = AV17AplIIGGExenCon ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_simnatexenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV17AplIIGGExenCon = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.stringToDec("0.4"), (byte)(1), AV12palabra, "", AV16CondExenIIGG, AV17AplIIGGExenCon, "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(1)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      GXt_char3 = AV14ConCodigo ;
      GXt_char1 = AV14ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topeprepaga_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV14ConCodigo = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope prepagas", ""), DecimalUtil.doubleToDec(1), (byte)(2), "", AV14ConCodigo, "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      GXt_char3 = AV14ConCodigo ;
      GXt_char1 = AV14ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topemedicos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV14ConCodigo = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope médicos", ""), DecimalUtil.doubleToDec(1), (byte)(2), "", AV14ConCodigo, "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[tope_seguros]" ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope seguros", ""), DecimalUtil.doubleToDec(1), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      GXt_char3 = AV14ConCodigo ;
      GXt_char1 = AV14ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_topedonaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV14ConCodigo = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope donaciones", ""), DecimalUtil.doubleToDec(1), (byte)(2), "", AV14ConCodigo, "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      GXt_char3 = AV14ConCodigo ;
      GXt_char1 = AV14ConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.retencionbruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV14ConCodigo = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope pagos a cuenta", ""), DecimalUtil.doubleToDec(1), (byte)(2), "", AV14ConCodigo, "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(2)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[tope_hipoteca]" ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope hipoteca", ""), DecimalUtil.doubleToDec(1), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV12palabra = "[tope_sepelio]" ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, httpContext.getMessage( "Tope sepelio", ""), DecimalUtil.doubleToDec(1), (byte)(1), AV12palabra, "", "", "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
      AV9AplIIGG = (short)(AV9AplIIGG+1) ;
      AV16CondExenIIGG = httpContext.getMessage( "PERSONALPOZO", "") ;
      AV15AplIIGGNom = httpContext.getMessage( "Exento para personal de pozo petrolero", "") ;
      GXt_char3 = AV17AplIIGGExenCon ;
      GXt_char1 = AV17AplIIGGExenCon ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_espersonaldepozo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char2) ;
      ini_tipo_aplicacion_ganancias.this.GXt_char3 = GXv_char2[0] ;
      AV17AplIIGGExenCon = GXt_char3 ;
      new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV8CliCod, AV9AplIIGG, AV15AplIIGGNom, DecimalUtil.doubleToDec(1), AV10TipoTope, "", "", AV16CondExenIIGG, "", "", DecimalUtil.doubleToDec(0), AV11AplIIGGTrat, (byte)(0)) ;
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
      AV15AplIIGGNom = "" ;
      AV12palabra = "" ;
      AV16CondExenIIGG = "" ;
      AV17AplIIGGExenCon = "" ;
      AV14ConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11AplIIGGTrat ;
   private byte AV10TipoTope ;
   private short AV9AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV12palabra ;
   private String AV16CondExenIIGG ;
   private String AV17AplIIGGExenCon ;
   private String AV14ConCodigo ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private String AV15AplIIGGNom ;
}

