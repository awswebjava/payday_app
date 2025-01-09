package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarsueldoprecalc extends GXProcedure
{
   public actualizarsueldoprecalc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarsueldoprecalc.class ), "" );
   }

   public actualizarsueldoprecalc( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      actualizarsueldoprecalc.this.AV20parametros = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV25Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Legnumero(), 8, 0))+httpContext.getMessage( " &param ", "")+AV20parametros) ;
      AV22parm_sueldoPrecalc.fromJSonString(AV20parametros, null);
      GXv_decimal1[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char2[0] = "" ;
      new web.leyendaaclaracionsueldo(remoteHandle, context).execute( AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Clicod(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Empcod(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Legnumero(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Legsueltipo(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Legsuelfecha(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Legsuelsec(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Parmimportes(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Parmsincod(), AV22parm_sueldoPrecalc.getgxTv_Sdtparm_sueldoPrecalc_Setcalcytxt(), false, GXv_decimal1, GXv_char2) ;
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
      AV25Pgmname = "" ;
      AV22parm_sueldoPrecalc = new web.Sdtparm_sueldoPrecalc(remoteHandle, context);
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      AV25Pgmname = "actualizarSueldoPrecalc" ;
      /* GeneXus formulas. */
      AV25Pgmname = "actualizarSueldoPrecalc" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12CliCod ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV25Pgmname ;
   private String GXv_char2[] ;
   private String AV20parametros ;
   private web.Sdtparm_sueldoPrecalc AV22parm_sueldoPrecalc ;
}

