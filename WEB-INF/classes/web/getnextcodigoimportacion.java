package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextcodigoimportacion extends GXProcedure
{
   public getnextcodigoimportacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextcodigoimportacion.class ), "" );
   }

   public getnextcodigoimportacion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      getnextcodigoimportacion.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getnextcodigoimportacion.this.AV9CliCod = aP0;
      getnextcodigoimportacion.this.AV8campo = aP1;
      getnextcodigoimportacion.this.AV18dependenciaCodigo = aP2;
      getnextcodigoimportacion.this.AV11Descrip = aP3;
      getnextcodigoimportacion.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17seguir = true ;
      AV15next = (short)(0) ;
      while ( AV17seguir )
      {
         GXt_char1 = AV10Codigo ;
         GXv_char2[0] = GXt_char1 ;
         new web.prefijocodigoimportacionlegajo(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
         getnextcodigoimportacion.this.GXt_char1 = GXv_char2[0] ;
         AV10Codigo = GXutil.trim( GXt_char1) + GXutil.substring( AV11Descrip, 1, 3) ;
         if ( AV15next > 0 )
         {
            AV10Codigo += GXutil.trim( GXutil.str( AV15next, 4, 0)) ;
         }
         if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Area", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getseccion(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Categoria", "")) == 0 )
         {
            GXv_int4[0] = AV21PaiCod ;
            new web.empresagetpais(remoteHandle, context).execute( AV9CliCod, AV20EmpCod, GXv_int4) ;
            getnextcodigoimportacion.this.AV21PaiCod = GXv_int4[0] ;
            GXv_int5[0] = AV22CliConveVer ;
            new web.getversiondeconvenio(remoteHandle, context).execute( AV9CliCod, AV21PaiCod, AV18dependenciaCodigo, GXv_int5) ;
            getnextcodigoimportacion.this.AV22CliConveVer = GXv_int5[0] ;
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getcategoria(remoteHandle, context).execute( AV9CliCod, AV22CliConveVer, AV18dependenciaCodigo, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Lugar de Pago", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getlugpag(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Banco", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getbanco(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Sindicato", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getsindicato(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Obra Social", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getobrasocial(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Plan Medico", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getplanmedico(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else if ( GXutil.strcmp(AV8campo, httpContext.getMessage( "Convenio", "")) == 0 )
         {
            GXv_char2[0] = "" ;
            GXv_boolean3[0] = AV17seguir ;
            new web.getconvenio(remoteHandle, context).execute( AV9CliCod, AV10Codigo, GXv_char2, GXv_boolean3) ;
            getnextcodigoimportacion.this.AV17seguir = GXv_boolean3[0] ;
         }
         else
         {
            AV17seguir = false ;
         }
         AV15next = (short)(AV15next+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getnextcodigoimportacion.this.AV10Codigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Codigo = "" ;
      GXt_char1 = "" ;
      GXv_int4 = new short[1] ;
      GXv_int5 = new int[1] ;
      GXv_char2 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15next ;
   private short AV20EmpCod ;
   private short AV21PaiCod ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV22CliConveVer ;
   private int GXv_int5[] ;
   private String AV8campo ;
   private String AV18dependenciaCodigo ;
   private String AV10Codigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV17seguir ;
   private boolean GXv_boolean3[] ;
   private String AV11Descrip ;
   private String[] aP4 ;
}

