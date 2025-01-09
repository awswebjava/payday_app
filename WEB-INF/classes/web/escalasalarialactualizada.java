package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escalasalarialactualizada extends GXProcedure
{
   public escalasalarialactualizada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escalasalarialactualizada.class ), "" );
   }

   public escalasalarialactualizada( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             boolean[] aP6 )
   {
      escalasalarialactualizada.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        boolean[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 )
   {
      escalasalarialactualizada.this.AV11CliCod = aP0;
      escalasalarialactualizada.this.AV13CliPaiConve = aP1;
      escalasalarialactualizada.this.AV12CliConvenio = aP2;
      escalasalarialactualizada.this.AV10CatCodigo = aP3;
      escalasalarialactualizada.this.AV20parm_UltiCatVigencia = aP4;
      escalasalarialactualizada.this.AV17fecha = aP5;
      escalasalarialactualizada.this.aP6 = aP6;
      escalasalarialactualizada.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV20parm_UltiCatVigencia)) )
      {
         GXv_date1[0] = AV22ultiCatVigencia ;
         new web.getultifecescala(remoteHandle, context).execute( AV11CliCod, AV13CliPaiConve, AV12CliConvenio, AV10CatCodigo, GXv_date1) ;
         escalasalarialactualizada.this.AV22ultiCatVigencia = GXv_date1[0] ;
      }
      else
      {
         AV22ultiCatVigencia = AV20parm_UltiCatVigencia ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV22ultiCatVigencia)) )
      {
         GXv_char2[0] = AV24error ;
         new web.getcoderrprin(remoteHandle, context).execute( GXv_char2) ;
         escalasalarialactualizada.this.AV24error = GXv_char2[0] ;
         AV24error += httpContext.getMessage( "La categoría del convenio no tiene cargada ninguna escala salarial", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_int3[0] = AV27auxCliPaiConve ;
      new web.getpaisdeconvenio(remoteHandle, context).execute( AV12CliConvenio, AV13CliPaiConve, GXv_int3) ;
      escalasalarialactualizada.this.AV27auxCliPaiConve = GXv_int3[0] ;
      GXv_int4[0] = (byte)(AV14ConveEscFrecAct) ;
      new web.getcatfecact(remoteHandle, context).execute( AV11CliCod, AV27auxCliPaiConve, AV12CliConvenio, AV10CatCodigo, GXv_int4) ;
      escalasalarialactualizada.this.AV14ConveEscFrecAct = GXv_int4[0] ;
      GXv_int3[0] = AV16diferenciaMeses ;
      new web.diferenciameses(remoteHandle, context).execute( AV11CliCod, AV22ultiCatVigencia, AV17fecha, (short)(99), GXv_int3) ;
      escalasalarialactualizada.this.AV16diferenciaMeses = GXv_int3[0] ;
      if ( AV16diferenciaMeses < AV14ConveEscFrecAct )
      {
         AV8actualizadaEsta = true ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "!&parm_UltiCatVigencia: ", "")+GXutil.trim( localUtil.dtoc( AV20parm_UltiCatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&CliPaiConve: ", "")+GXutil.trim( GXutil.str( AV13CliPaiConve, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&CliConvenio: ", "")+GXutil.trim( AV12CliConvenio)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&CatCodigo: ", "")+GXutil.trim( AV10CatCodigo)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&ultiCatVigencia: ", "")+GXutil.trim( localUtil.dtoc( AV22ultiCatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&ConveEscFrecAct: ", "")+GXutil.trim( GXutil.str( AV14ConveEscFrecAct, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&fecha: ", "")+GXutil.trim( localUtil.dtoc( AV17fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&diferenciaMeses: ", "")+GXutil.trim( GXutil.str( AV16diferenciaMeses, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV30Pgmname, httpContext.getMessage( "&&dias: ", "")+GXutil.trim( GXutil.str( AV26dias, 4, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = escalasalarialactualizada.this.AV8actualizadaEsta;
      this.aP7[0] = escalasalarialactualizada.this.AV24error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24error = "" ;
      AV22ultiCatVigencia = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int3 = new short[1] ;
      AV30Pgmname = "" ;
      AV30Pgmname = "escalaSalarialActualizada" ;
      /* GeneXus formulas. */
      AV30Pgmname = "escalaSalarialActualizada" ;
      Gx_err = (short)(0) ;
   }

   private byte GXv_int4[] ;
   private short AV13CliPaiConve ;
   private short AV27auxCliPaiConve ;
   private short AV14ConveEscFrecAct ;
   private short AV16diferenciaMeses ;
   private short GXv_int3[] ;
   private short AV26dias ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV12CliConvenio ;
   private String AV10CatCodigo ;
   private String GXv_char2[] ;
   private String AV30Pgmname ;
   private java.util.Date AV20parm_UltiCatVigencia ;
   private java.util.Date AV17fecha ;
   private java.util.Date AV22ultiCatVigencia ;
   private java.util.Date GXv_date1[] ;
   private boolean AV8actualizadaEsta ;
   private boolean returnInSub ;
   private String AV24error ;
   private String[] aP7 ;
   private boolean[] aP6 ;
}

