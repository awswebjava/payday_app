package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirestadocivil extends GXProcedure
{
   public traducirestadocivil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirestadocivil.class ), "" );
   }

   public traducirestadocivil( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              short[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirestadocivil.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirestadocivil.this.AV16CliCod = aP0;
      traducirestadocivil.this.AV12MigrLegEstadoCivil = aP1;
      traducirestadocivil.this.aP2 = aP2;
      traducirestadocivil.this.AV15errores = aP3[0];
      this.aP3 = aP3;
      traducirestadocivil.this.aP4 = aP4;
      traducirestadocivil.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12MigrLegEstadoCivil ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV16CliCod, GXv_char2) ;
      traducirestadocivil.this.GXt_char1 = GXv_char2[0] ;
      AV12MigrLegEstadoCivil = GXutil.strReplace( AV12MigrLegEstadoCivil, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV12MigrLegEstadoCivil)==0) )
      {
         GXt_int3 = AV17PaiCod ;
         GXv_int4[0] = GXt_int3 ;
         new web.clientegetpais(remoteHandle, context).execute( AV16CliCod, GXv_int4) ;
         traducirestadocivil.this.GXt_int3 = GXv_int4[0] ;
         AV17PaiCod = GXt_int3 ;
         if ( ( GXutil.strSearch( GXutil.upper( AV12MigrLegEstadoCivil), httpContext.getMessage( "CASA", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV12MigrLegEstadoCivil), httpContext.getMessage( "CONV", ""), 1) != 0 ) )
         {
            GXt_int3 = AV11LegEstadoCivil ;
            GXv_int4[0] = GXt_int3 ;
            new web.getestadocivillikedescrip(remoteHandle, context).execute( AV17PaiCod, httpContext.getMessage( "CASA", ""), GXv_int4) ;
            traducirestadocivil.this.GXt_int3 = GXv_int4[0] ;
            AV11LegEstadoCivil = GXt_int3 ;
         }
         else
         {
            if ( GXutil.strSearch( GXutil.upper( AV12MigrLegEstadoCivil), httpContext.getMessage( "SOLT", ""), 1) != 0 )
            {
               GXt_int3 = AV11LegEstadoCivil ;
               GXv_int4[0] = GXt_int3 ;
               new web.getestadocivillikedescrip(remoteHandle, context).execute( AV17PaiCod, httpContext.getMessage( "SOLT", ""), GXv_int4) ;
               traducirestadocivil.this.GXt_int3 = GXv_int4[0] ;
               AV11LegEstadoCivil = GXt_int3 ;
            }
            else
            {
               GXt_int3 = AV11LegEstadoCivil ;
               GXv_int4[0] = GXt_int3 ;
               new web.getestadocivillikedescrip(remoteHandle, context).execute( AV17PaiCod, httpContext.getMessage( "OTR", ""), GXv_int4) ;
               traducirestadocivil.this.GXt_int3 = GXv_int4[0] ;
               AV11LegEstadoCivil = GXt_int3 ;
            }
         }
      }
      if ( ! (0==AV11LegEstadoCivil) )
      {
         AV8encontro = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = traducirestadocivil.this.AV11LegEstadoCivil;
      this.aP3[0] = traducirestadocivil.this.AV15errores;
      this.aP4[0] = traducirestadocivil.this.AV9error;
      this.aP5[0] = traducirestadocivil.this.AV8encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9error = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11LegEstadoCivil ;
   private short AV17PaiCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV16CliCod ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV8encontro ;
   private String AV12MigrLegEstadoCivil ;
   private String AV9error ;
   private boolean[] aP5 ;
   private short[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV15errores ;
}

