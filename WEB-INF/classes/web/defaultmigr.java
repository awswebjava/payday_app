package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultmigr extends GXProcedure
{
   public defaultmigr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultmigr.class ), "" );
   }

   public defaultmigr( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      defaultmigr.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      defaultmigr.this.AV8CliCod = aP0;
      defaultmigr.this.AV14EmpCod = aP1;
      defaultmigr.this.AV10campo = aP2;
      defaultmigr.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Tipo de tarifa", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "Por periodo trabajado", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Relación laboral", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "Empleado", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Convenio", "")) == 0 )
      {
         GXv_char1[0] = AV9texto ;
         new web.getconveniodefault(remoteHandle, context).execute( AV8CliCod, AV14EmpCod, "", GXv_char1) ;
         defaultmigr.this.AV9texto = GXv_char1[0] ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Sindicato", "")) == 0 )
      {
         GXv_char1[0] = AV9texto ;
         new web.getsindicatodefault(remoteHandle, context).execute( AV8CliCod, AV14EmpCod, GXv_char1) ;
         defaultmigr.this.AV9texto = GXv_char1[0] ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Frecuencia de pago", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "MENSUAL", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Forma de Pago", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "TRANSFERENCIA", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Tipo de Cuenta", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "CAJA DE AHORRO", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad", "")) == 0 )
      {
         GXt_char2 = AV12ParmValue ;
         GXt_char3 = AV12ParmValue ;
         GXv_char1[0] = GXt_char3 ;
         new web.actividad_codigoparam(remoteHandle, context).execute( GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         GXv_char4[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         AV12ParmValue = GXt_char2 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getactividad(remoteHandle, context).execute( AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Modalidad", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.modalidad_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getmodalidad(remoteHandle, context).execute( AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Zona", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.zona_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getzona(remoteHandle, context).execute( AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "SCVO", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "SI", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Estado Civil", "")) == 0 )
      {
         AV9texto = httpContext.getMessage( "SOLTERO", "") ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Situación", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.situacion_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getsituacion(remoteHandle, context).execute( AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Condición", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.condicion_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getcondicion(remoteHandle, context).execute( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV12ParmValue, "."))), GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Siniestrado", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.siniestrado_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getsiniestrado(remoteHandle, context).execute( AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Area", "")) == 0 )
      {
         GXt_char3 = AV12ParmValue ;
         GXt_char2 = AV12ParmValue ;
         GXv_char4[0] = GXt_char2 ;
         new web.seccion_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         defaultmigr.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char1) ;
         defaultmigr.this.GXt_char3 = GXv_char1[0] ;
         AV12ParmValue = GXt_char3 ;
         GXv_char4[0] = AV13Descrip ;
         GXv_boolean5[0] = false ;
         new web.getseccion(remoteHandle, context).execute( AV8CliCod, AV12ParmValue, GXv_char4, GXv_boolean5) ;
         defaultmigr.this.AV13Descrip = GXv_char4[0] ;
         AV9texto = GXutil.upper( GXutil.trim( AV13Descrip)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = defaultmigr.this.AV9texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9texto = "" ;
      AV12ParmValue = "" ;
      AV13Descrip = "" ;
      GXt_char3 = "" ;
      GXt_char2 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV10campo ;
   private String GXt_char3 ;
   private String GXt_char2 ;
   private String GXv_char1[] ;
   private String GXv_char4[] ;
   private boolean GXv_boolean5[] ;
   private String AV12ParmValue ;
   private String AV9texto ;
   private String AV13Descrip ;
   private String[] aP3 ;
}

