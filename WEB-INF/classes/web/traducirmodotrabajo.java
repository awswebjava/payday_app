package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirmodotrabajo extends GXProcedure
{
   public traducirmodotrabajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirmodotrabajo.class ), "" );
   }

   public traducirmodotrabajo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int[] aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirmodotrabajo.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int[] aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int[] aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirmodotrabajo.this.AV14CliCod = aP0[0];
      this.aP0 = aP0;
      traducirmodotrabajo.this.AV15MigrLegModTra = aP1;
      traducirmodotrabajo.this.aP2 = aP2;
      traducirmodotrabajo.this.AV13errores = aP3[0];
      this.aP3 = aP3;
      traducirmodotrabajo.this.aP4 = aP4;
      traducirmodotrabajo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV15MigrLegModTra ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV14CliCod, GXv_char2) ;
      traducirmodotrabajo.this.GXt_char1 = GXv_char2[0] ;
      AV15MigrLegModTra = GXutil.strReplace( AV15MigrLegModTra, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV15MigrLegModTra)==0) )
      {
         AV21GXV2 = 1 ;
         AV20GXV1 = web.gxdomainmodo_trabajo.getValues() ;
         while ( AV21GXV2 <= AV20GXV1.size() )
         {
            AV16modo_trabajo = (String)AV20GXV1.elementAt(-1+AV21GXV2) ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV16modo_trabajo), ""))), GXutil.upper( GXutil.trim( AV15MigrLegModTra))) == 0 )
            {
               AV17LegModTra = AV16modo_trabajo ;
               AV9encontro = true ;
               if (true) break;
            }
            if ( ! AV9encontro && ( GXutil.len( GXutil.trim( AV15MigrLegModTra)) == 1 ) )
            {
               if ( GXutil.strcmp(GXutil.substring( GXutil.upper( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV16modo_trabajo), "")), 1, 1), GXutil.upper( GXutil.trim( AV15MigrLegModTra))) == 0 )
               {
                  AV17LegModTra = AV16modo_trabajo ;
                  AV9encontro = true ;
                  if (true) break;
               }
            }
            AV21GXV2 = (int)(AV21GXV2+1) ;
         }
         if ( ! AV9encontro )
         {
            GXt_char1 = AV10error ;
            GXv_char2[0] = GXt_char1 ;
            new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "Relación laboral", ""), AV15MigrLegModTra, (short)(1), GXv_char2) ;
            traducirmodotrabajo.this.GXt_char1 = GXv_char2[0] ;
            AV10error = GXt_char1 ;
            AV13errores.add(AV10error, 0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = traducirmodotrabajo.this.AV14CliCod;
      this.aP2[0] = traducirmodotrabajo.this.AV17LegModTra;
      this.aP3[0] = traducirmodotrabajo.this.AV13errores;
      this.aP4[0] = traducirmodotrabajo.this.AV10error;
      this.aP5[0] = traducirmodotrabajo.this.AV9encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17LegModTra = "" ;
      AV10error = "" ;
      AV20GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16modo_trabajo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14CliCod ;
   private int AV21GXV2 ;
   private String AV17LegModTra ;
   private String AV16modo_trabajo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV9encontro ;
   private String AV15MigrLegModTra ;
   private String AV10error ;
   private boolean[] aP5 ;
   private int[] aP0 ;
   private String[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV20GXV1 ;
   private GXSimpleCollection<String> AV13errores ;
}

