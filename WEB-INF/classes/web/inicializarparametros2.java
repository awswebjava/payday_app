package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarparametros2 extends GXProcedure
{
   public inicializarparametros2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarparametros2.class ), "" );
   }

   public inicializarparametros2( int remoteHandle ,
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
      inicializarparametros2.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV20ConDescrip ;
      GXv_char2[0] = GXt_char1 ;
      new web.getdescripcionremuneracionbruta(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
      inicializarparametros2.this.GXt_char1 = GXv_char2[0] ;
      AV20ConDescrip = GXt_char1 ;
      GXt_char1 = AV19RemuneracionBrutaConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, AV20ConDescrip, GXv_char2) ;
      inicializarparametros2.this.GXt_char1 = GXv_char2[0] ;
      AV19RemuneracionBrutaConCodigo = GXt_char1 ;
      if ( (GXutil.strcmp("", AV19RemuneracionBrutaConCodigo)==0) )
      {
         GXv_char2[0] = AV19RemuneracionBrutaConCodigo ;
         new web.conceptosueldobruto(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
         inicializarparametros2.this.AV19RemuneracionBrutaConCodigo = GXv_char2[0] ;
      }
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldobruto_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV19RemuneracionBrutaConCodigo), httpContext.getMessage( "Concepto \"", "")+GXutil.trim( AV20ConDescrip)+"\"") ;
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
      AV20ConDescrip = "" ;
      AV19RemuneracionBrutaConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV19RemuneracionBrutaConCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV20ConDescrip ;
}

