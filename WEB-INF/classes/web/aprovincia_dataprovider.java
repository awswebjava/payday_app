package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aprovincia_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      aprovincia_dataprovider pgm = new aprovincia_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtProvincia>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtProvincia>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public aprovincia_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aprovincia_dataprovider.class ), "" );
   }

   public aprovincia_dataprovider( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtProvincia> executeUdp( )
   {
      aprovincia_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtProvincia>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtProvincia>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtProvincia>[] aP0 )
   {
      aprovincia_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(1) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Ciudad autónoma de Buenos Aires", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(2) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Buenos Aires", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(3) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Catamarca", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(4) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Córdoba", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(5) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Corrientes", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(6) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Chaco", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(7) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Chubut", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(8) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Entre Ríos", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(9) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Formosa", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(10) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Jujuy", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(11) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "La Pampa", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "La Rioja", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(13) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Mendoza", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(14) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Misiones", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(15) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Neuquén", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(16) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Río Negro", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(17) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Salta", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(18) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "San Juan", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(19) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "San Luis", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(20) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Santa Cruz", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(21) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Santa Fe", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(22) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Santiago del Estero", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(23) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Tierra del Fuego", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      Gxm1provincia = (web.SdtProvincia)new web.SdtProvincia( remoteHandle, context);
      Gxm2rootcol.add(Gxm1provincia, 0);
      Gxm1provincia.setgxTv_SdtProvincia_Paicod( (short)(12) );
      Gxm1provincia.setgxTv_SdtProvincia_Provcod( (short)(24) );
      Gxm1provincia.setgxTv_SdtProvincia_Provnom( httpContext.getMessage( "Tucumán", "") );
      Gxm1provincia.setgxTv_SdtProvincia_Provsiradig( (short)(0) );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(provincia_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aprovincia_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtProvincia>(web.SdtProvincia.class, "Provincia", "PayDay", remoteHandle);
      Gxm1provincia = new web.SdtProvincia(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtProvincia>[] aP0 ;
   private GXBCCollection<web.SdtProvincia> Gxm2rootcol ;
   private web.SdtProvincia Gxm1provincia ;
}

