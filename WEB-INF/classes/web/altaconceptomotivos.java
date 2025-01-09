package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class altaconceptomotivos extends GXProcedure
{
   public altaconceptomotivos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( altaconceptomotivos.class ), "" );
   }

   public altaconceptomotivos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      altaconceptomotivos.this.AV8CliCod = aP0;
      altaconceptomotivos.this.AV9ConCodigo = aP1;
      altaconceptomotivos.this.AV10ConDescrip = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV10ConDescrip, httpContext.getMessage( "INDEMNIZACIÓN ANTIGUEDAD", "")) == 0 )
      {
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "DES2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F52 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(0) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FUE", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F53 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "MAT", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.25") ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F54 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU1", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F55 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU2", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F56 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(4) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "JUB", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F57 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(5) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "MUE", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F58 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(6) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FAL", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F59 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(7) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      else if ( GXutil.strcmp(AV10ConDescrip, httpContext.getMessage( "INTEGRACIÓN MES DE DESPIDO", "")) == 0 )
      {
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "DES2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F510 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(8) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FUE", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F511 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(9) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU1", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F512 */
         pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(10) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F513 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(11) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "JUB", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F514 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(12) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      else if ( GXutil.strcmp(AV10ConDescrip, httpContext.getMessage( "INDEMNIZACIÓN SUSTITUTIVA DEL PREAVISO", "")) == 0 )
      {
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "DES2", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(0) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F515 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(13) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FUE", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(0) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F516 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(14) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU1", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(0) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F517 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(15) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU2", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(0) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F518 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(16) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "JUB", "") ;
         A1529ConMegPropor = DecimalUtil.stringToDec("0.5") ;
         A1530ConMegMeses = (byte)(0) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F519 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(17) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "DES2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F520 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(18) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FUE", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F521 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(19) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU1", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F522 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(20) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F523 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(21) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "JUB", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(1) ;
         A1530ConMegMeses = (byte)(3) ;
         A1534ConMegDura = "meses" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F524 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(22) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "DES2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(2) ;
         A1530ConMegMeses = (byte)(5) ;
         A1534ConMegDura = "años" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F525 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(23) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "FUE", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(2) ;
         A1530ConMegMeses = (byte)(5) ;
         A1534ConMegDura = "años" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F526 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(24) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU1", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(2) ;
         A1530ConMegMeses = (byte)(5) ;
         A1534ConMegDura = "años" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F527 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(25) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "QU2", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(2) ;
         A1530ConMegMeses = (byte)(5) ;
         A1534ConMegDura = "años" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F528 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(26) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV8CliCod ;
         A26ConCodigo = AV9ConCodigo ;
         A11MegCodigo = httpContext.getMessage( "JUB", "") ;
         A1529ConMegPropor = DecimalUtil.doubleToDec(2) ;
         A1530ConMegMeses = (byte)(5) ;
         A1534ConMegDura = "años" ;
         A1532MegPreaTipo = "SIN" ;
         AV11ConMegSec = (short)(AV11ConMegSec+1) ;
         A2077ConMegSec = AV11ConMegSec ;
         /* Using cursor P01F529 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(27) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "altaconceptomotivos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A26ConCodigo = "" ;
      A11MegCodigo = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      A1534ConMegDura = "" ;
      A1532MegPreaTipo = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.altaconceptomotivos__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1530ConMegMeses ;
   private short AV11ConMegSec ;
   private short A2077ConMegSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GX_INS261 ;
   private int A3CliCod ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String AV9ConCodigo ;
   private String A26ConCodigo ;
   private String A11MegCodigo ;
   private String A1534ConMegDura ;
   private String A1532MegPreaTipo ;
   private String Gx_emsg ;
   private String AV10ConDescrip ;
   private IDataStoreProvider pr_default ;
}

final  class altaconceptomotivos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01F52", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F53", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F54", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F55", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F56", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F57", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F58", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F59", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F510", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F511", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F512", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F513", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F514", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F515", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F516", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F517", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F518", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F519", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F520", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F521", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F522", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F523", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F524", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F525", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F526", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F527", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F528", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01F529", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
      }
   }

}

