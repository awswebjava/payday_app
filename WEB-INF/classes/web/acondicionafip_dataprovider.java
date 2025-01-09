package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class acondicionafip_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      acondicionafip_dataprovider pgm = new acondicionafip_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtCondicionAFIP>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtCondicionAFIP>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public acondicionafip_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( acondicionafip_dataprovider.class ), "" );
   }

   public acondicionafip_dataprovider( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtCondicionAFIP> executeUdp( )
   {
      acondicionafip_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtCondicionAFIP>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtCondicionAFIP>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtCondicionAFIP>[] aP0 )
   {
      acondicionafip_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(1) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Servicios Comunes Mayor de 18 Años", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(2) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Jubilado", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(3) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Menor", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(5) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Servicios Diferenciados Mayor de 18 Años", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(6) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Sin Servicios Reales", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(7) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Medida de no Innovar Servicios Comunes", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(8) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Medida de no Innovar Serv.Diferenciados", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(9) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Jubilado Decreto nro 206/00", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(10) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Pension (NO SIPA)", "") );
      Gxm1condicionafip = (web.SdtCondicionAFIP)new web.SdtCondicionAFIP( remoteHandle, context);
      Gxm2rootcol.add(Gxm1condicionafip, 0);
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condicodigo( (short)(11) );
      Gxm1condicionafip.setgxTv_SdtCondicionAFIP_Condidescri( httpContext.getMessage( "Pension no Contributiva (NO SIPA)", "") );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(condicionafip_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = acondicionafip_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtCondicionAFIP>(web.SdtCondicionAFIP.class, "CondicionAFIP", "PayDay", remoteHandle);
      Gxm1condicionafip = new web.SdtCondicionAFIP(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtCondicionAFIP>[] aP0 ;
   private GXBCCollection<web.SdtCondicionAFIP> Gxm2rootcol ;
   private web.SdtCondicionAFIP Gxm1condicionafip ;
}

