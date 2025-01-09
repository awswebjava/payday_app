package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirclaselegajo extends GXProcedure
{
   public traducirclaselegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirclaselegajo.class ), "" );
   }

   public traducirclaselegajo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int[] aP0 ,
                              String aP1 ,
                              byte[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirclaselegajo.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int[] aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int[] aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirclaselegajo.this.AV14CliCod = aP0[0];
      this.aP0 = aP0;
      traducirclaselegajo.this.AV12MigrLegClase = aP1;
      traducirclaselegajo.this.aP2 = aP2;
      traducirclaselegajo.this.AV13errores = aP3[0];
      this.aP3 = aP3;
      traducirclaselegajo.this.aP4 = aP4;
      traducirclaselegajo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12MigrLegClase ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
      traducirclaselegajo.this.GXt_char1 = GXv_char2[0] ;
      AV12MigrLegClase = GXutil.strReplace( AV12MigrLegClase, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV12MigrLegClase)==0) )
      {
         AV18GXV2 = 1 ;
         AV17GXV1 = web.gxdomainclaseleg.getValues() ;
         while ( AV18GXV2 <= AV17GXV1.size() )
         {
            AV8ClaseLeg = ((Number) AV17GXV1.elementAt(-1+AV18GXV2)).byteValue() ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV8ClaseLeg), ""))), GXutil.upper( GXutil.trim( AV12MigrLegClase))) == 0 )
            {
               AV11LegClase = AV8ClaseLeg ;
               AV9encontro = true ;
               if (true) break;
            }
            if ( ! AV9encontro && ( GXutil.len( GXutil.trim( AV12MigrLegClase)) == 1 ) )
            {
               if ( GXutil.strcmp(GXutil.substring( GXutil.upper( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV8ClaseLeg), "")), 1, 1), GXutil.upper( GXutil.trim( AV12MigrLegClase))) == 0 )
               {
                  AV11LegClase = AV8ClaseLeg ;
                  AV9encontro = true ;
                  if (true) break;
               }
            }
            AV18GXV2 = (int)(AV18GXV2+1) ;
         }
         if ( ! AV9encontro )
         {
            GXt_char1 = AV10error ;
            GXv_char2[0] = GXt_char1 ;
            new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "Frecuencia de pago", ""), AV12MigrLegClase, (short)(1), GXv_char2) ;
            traducirclaselegajo.this.GXt_char1 = GXv_char2[0] ;
            AV10error = GXt_char1 ;
            AV13errores.add(AV10error, 0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = traducirclaselegajo.this.AV14CliCod;
      this.aP2[0] = traducirclaselegajo.this.AV11LegClase;
      this.aP3[0] = traducirclaselegajo.this.AV13errores;
      this.aP4[0] = traducirclaselegajo.this.AV10error;
      this.aP5[0] = traducirclaselegajo.this.AV9encontro;
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
      AV17GXV1 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11LegClase ;
   private byte AV8ClaseLeg ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV18GXV2 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV9encontro ;
   private String AV12MigrLegClase ;
   private String AV10error ;
   private GXSimpleCollection<Byte> AV17GXV1 ;
   private boolean[] aP5 ;
   private int[] aP0 ;
   private byte[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV13errores ;
}

