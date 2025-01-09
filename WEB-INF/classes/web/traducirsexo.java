package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirsexo extends GXProcedure
{
   public traducirsexo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirsexo.class ), "" );
   }

   public traducirsexo( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              byte[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirsexo.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirsexo.this.AV12CliCod = aP0;
      traducirsexo.this.AV8MigrLegSexo = aP1;
      traducirsexo.this.aP2 = aP2;
      traducirsexo.this.AV11errores = aP3[0];
      this.aP3 = aP3;
      traducirsexo.this.aP4 = aP4;
      traducirsexo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV8MigrLegSexo)==0) )
      {
         GXv_int1[0] = AV14PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int1) ;
         traducirsexo.this.AV14PaiCod = GXv_int1[0] ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8MigrLegSexo)), httpContext.getMessage( "MASCULINO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8MigrLegSexo)), httpContext.getMessage( "M", "")) == 0 ) )
         {
            GXv_int2[0] = AV9LegSexo ;
            GXv_boolean3[0] = AV13encontro ;
            new web.getsexoidporbioiden(remoteHandle, context).execute( AV14PaiCod, "macho", "macho", GXv_int2, GXv_boolean3) ;
            traducirsexo.this.AV9LegSexo = GXv_int2[0] ;
            traducirsexo.this.AV13encontro = GXv_boolean3[0] ;
         }
         else
         {
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8MigrLegSexo)), httpContext.getMessage( "FEMENINO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8MigrLegSexo)), httpContext.getMessage( "F", "")) == 0 ) )
            {
               GXv_int2[0] = AV9LegSexo ;
               GXv_boolean3[0] = AV13encontro ;
               new web.getsexoidporbioiden(remoteHandle, context).execute( AV14PaiCod, "hembra", "hembra", GXv_int2, GXv_boolean3) ;
               traducirsexo.this.AV9LegSexo = GXv_int2[0] ;
               traducirsexo.this.AV13encontro = GXv_boolean3[0] ;
            }
            else
            {
               GXt_char4 = AV10error ;
               GXv_char5[0] = GXt_char4 ;
               new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV12CliCod, httpContext.getMessage( "Género", ""), AV8MigrLegSexo, (short)(1), GXv_char5) ;
               traducirsexo.this.GXt_char4 = GXv_char5[0] ;
               AV10error = GXt_char4 ;
               AV11errores.add(AV10error, 0);
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&MigrLegSexo: ", "")+GXutil.trim( AV8MigrLegSexo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&PaiCod: ", "")+GXutil.trim( GXutil.str( AV14PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&LegSexo: ", "")+GXutil.trim( GXutil.str( AV9LegSexo, 2, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&encontro: ", "")+GXutil.trim( GXutil.booltostr( AV13encontro))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&error: ", "")+GXutil.trim( AV10error)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = traducirsexo.this.AV9LegSexo;
      this.aP3[0] = traducirsexo.this.AV11errores;
      this.aP4[0] = traducirsexo.this.AV10error;
      this.aP5[0] = traducirsexo.this.AV13encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10error = "" ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new byte[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV17Pgmname = "" ;
      AV17Pgmname = "TraducirSexo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "TraducirSexo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LegSexo ;
   private byte GXv_int2[] ;
   private short AV14PaiCod ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV8MigrLegSexo ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String AV17Pgmname ;
   private boolean AV13encontro ;
   private boolean GXv_boolean3[] ;
   private String AV10error ;
   private boolean[] aP5 ;
   private byte[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV11errores ;
}

