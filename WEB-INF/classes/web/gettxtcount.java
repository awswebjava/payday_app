package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettxtcount extends GXProcedure
{
   public gettxtcount( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettxtcount.class ), "" );
   }

   public gettxtcount( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      gettxtcount.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      gettxtcount.this.AV13MenuOpcCod = aP0;
      gettxtcount.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8SecUserId ;
      GXv_int2[0] = GXt_int1 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
      gettxtcount.this.GXt_int1 = GXv_int2[0] ;
      AV8SecUserId = GXt_int1 ;
      GXv_int3[0] = AV9RolId ;
      GXv_int4[0] = AV10PerfilId ;
      GXv_int5[0] = AV11MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV8SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      gettxtcount.this.AV9RolId = GXv_int3[0] ;
      gettxtcount.this.AV10PerfilId = GXv_int4[0] ;
      gettxtcount.this.AV11MenuVerId = GXv_int5[0] ;
      GXv_char6[0] = AV12MenuOpcTitulo ;
      new web.getmenuopctitulo(remoteHandle, context).execute( AV9RolId, AV10PerfilId, AV11MenuVerId, AV13MenuOpcCod, GXv_char6) ;
      gettxtcount.this.AV12MenuOpcTitulo = GXv_char6[0] ;
      GXt_int7 = AV14CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      gettxtcount.this.GXt_int7 = GXv_int8[0] ;
      AV14CliCod = GXt_int7 ;
      if ( (GXutil.strcmp("", AV12MenuOpcTitulo)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV12MenuOpcTitulo = httpContext.getMessage( "registros", "") ;
      }
      else
      {
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Importar", ""), "") ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Deducciones y reintegros", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Formulario 1357", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Horas trabajadas y conceptos adicionales", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Faltas y llegadas tarde", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Vacaciones y licencias", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Cuotas descuentos y acreditaciones", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Reporte", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Libro de sueldos digital", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Exportar liquidaciones", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Cuenta corriente de vacaciones", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Antiguedad / permanencias", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Feriados", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Licencias", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Horas extras", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Horas extras extraordinarias", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Religiones reconocidas para días no laborables", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Origenes reconocidos para días no laborables", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Tratamientos de exención iigg", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Condiciones de exención", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Códigos siradig", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Agenda de feriados", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Estados / licencias", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Embargabilidad", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "a.r.t.", ""), httpContext.getMessage( "registros", "")) ;
         AV12MenuOpcTitulo = GXutil.strReplace( AV12MenuOpcTitulo, httpContext.getMessage( "Siniestrados", ""), httpContext.getMessage( "registros", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gettxtcount.this.AV12MenuOpcTitulo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MenuOpcTitulo = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      GXv_char6 = new String[1] ;
      GXv_int8 = new int[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9RolId ;
   private byte GXv_int3[] ;
   private byte AV10PerfilId ;
   private byte GXv_int4[] ;
   private short AV8SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private long AV11MenuVerId ;
   private long GXv_int5[] ;
   private String GXv_char6[] ;
   private boolean Cond_result ;
   private String AV13MenuOpcCod ;
   private String AV12MenuOpcTitulo ;
   private String[] aP1 ;
}

