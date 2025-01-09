package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_bancos extends GXProcedure
{
   public ini_bancos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_bancos.class ), "" );
   }

   public ini_bancos( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> executeUdp( )
   {
      ini_bancos.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP0 )
   {
      ini_bancos.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00007", httpContext.getMessage( "BANCO DE GALICIA Y BUENOS AIRES S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00011", httpContext.getMessage( "BANCO DE LA NACION ARGENTINA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00014", httpContext.getMessage( "BANCO DE LA PROVINCIA DE BUENOS AIRES", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00015", httpContext.getMessage( "INDUSTRIAL AND COMMERCIAL BANK OF CHINA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00016", httpContext.getMessage( "CITIBANK N.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00017", httpContext.getMessage( "BANCO BBVA ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00020", httpContext.getMessage( "BANCO DE LA PROVINCIA DE CORDOBA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00027", httpContext.getMessage( "BANCO SUPERVIELLE S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00029", httpContext.getMessage( "BANCO DE LA CIUDAD DE BUENOS AIRES", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00034", httpContext.getMessage( "BANCO PATAGONIA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00044", httpContext.getMessage( "BANCO HIPOTECARIO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00045", httpContext.getMessage( "BANCO DE SAN JUAN S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00065", httpContext.getMessage( "BANCO MUNICIPAL DE ROSARIO", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00072", httpContext.getMessage( "BANCO SANTANDER RIO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00083", httpContext.getMessage( "BANCO DEL CHUBUT S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00086", httpContext.getMessage( "BANCO DE SANTA CRUZ S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00093", httpContext.getMessage( "BANCO DE LA PAMPA SOCIEDAD DE ECONOMÍA MIXTA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00094", httpContext.getMessage( "BANCO DE CORRIENTES S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00097", httpContext.getMessage( "BANCO PROVINCIA DEL NEUQUÉN SOCIEDAD ANÓMIA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00143", httpContext.getMessage( "BRUBANK S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00147", httpContext.getMessage( "BANCO INTERFINANZAS S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00150", httpContext.getMessage( "HSBC BANK ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00158", httpContext.getMessage( "OPEN BANK ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00165", httpContext.getMessage( "JPMORGAN CHASE BANK, NATIONAL ASSOCIATION", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00191", httpContext.getMessage( "BANCO CREDICOOP COOPERATIVO LIMITADO", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00198", httpContext.getMessage( "BANCO DE VALORES S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00247", httpContext.getMessage( "BANCO ROELA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00254", httpContext.getMessage( "BANCO MARIVA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00259", httpContext.getMessage( "BANCO ITAU ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00266", httpContext.getMessage( "BNP PARIBAS", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00268", httpContext.getMessage( "BANCO PROVINCIA DE TIERRA DEL FUEGO", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00269", httpContext.getMessage( "BANCO DE LA REPUBLICA ORIENTAL DEL URUGU", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00277", httpContext.getMessage( "BANCO SAENZ S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00281", httpContext.getMessage( "BANCO MERIDIAN S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00285", httpContext.getMessage( "BANCO MACRO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00299", httpContext.getMessage( "BANCO COMAFI SOCIEDAD ANONIMA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00300", httpContext.getMessage( "BANCO DE INVERSION Y COMERCIO EXTERIOR S", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00301", httpContext.getMessage( "BANCO PIANO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00305", httpContext.getMessage( "BANCO JULIO SOCIEDAD ANONIMA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00309", httpContext.getMessage( "BANCO RIOJA SOCIEDAD ANONIMA UNIPERSONAL", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00310", httpContext.getMessage( "BANCO DEL SOL S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00311", httpContext.getMessage( "NUEVO BANCO DEL CHACO S. A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00312", httpContext.getMessage( "BANCO VOII S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00315", httpContext.getMessage( "BANCO DE FORMOSA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00319", httpContext.getMessage( "BANCO CMF S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00321", httpContext.getMessage( "BANCO DE SANTIAGO DEL ESTERO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00322", httpContext.getMessage( "BANCO INDUSTRIAL S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00330", httpContext.getMessage( "NUEVO BANCO DE SANTA FE SOCIEDAD ANONIMA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00331", httpContext.getMessage( "BANCO CETELEM ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00332", httpContext.getMessage( "BANCO DE SERVICIOS FINANCIEROS S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00336", httpContext.getMessage( "BANCO BRADESCO ARGENTINA S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00338", httpContext.getMessage( "BANCO DE SERVICIOS Y TRANSACCIONES S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00339", httpContext.getMessage( "RCI BANQUE S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00340", httpContext.getMessage( "BACS BANCO DE CREDITO Y SECURITIZACION S", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00341", httpContext.getMessage( "BANCO MASVENTAS S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00384", httpContext.getMessage( "WILOBANK S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00386", httpContext.getMessage( "NUEVO BANCO DE ENTRE RÍOS S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00389", httpContext.getMessage( "BANCO COLUMBIA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00426", httpContext.getMessage( "BANCO BICA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00431", httpContext.getMessage( "BANCO COINAG S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00432", httpContext.getMessage( "BANCO DE COMERCIO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00435", httpContext.getMessage( "BANCO SUCREDITO REGIONAL S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00448", httpContext.getMessage( "BANCO DINO S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "00515", httpContext.getMessage( "BANK OF CHINA LIMITED SUCURSAL BUENOS AI", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44059", httpContext.getMessage( "FORD CREDIT COMPAÑIA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44077", httpContext.getMessage( "COMPAÑIA FINANCIERA ARGENTINA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44088", httpContext.getMessage( "VOLKSWAGEN FINANCIAL SERVICES COMPAÑIA F", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44090", httpContext.getMessage( "IUDU COMPAÑÍA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44092", httpContext.getMessage( "FCA COMPAÑIA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44093", httpContext.getMessage( "GPAT COMPAÑIA FINANCIERA S.A.U.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44094", httpContext.getMessage( "MERCEDES-BENZ COMPAÑÍA FINANCIERA ARGENT", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44095", httpContext.getMessage( "ROMBO COMPAÑÍA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44096", httpContext.getMessage( "JOHN DEERE CREDIT COMPAÑÍA FINANCIERA S.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44098", httpContext.getMessage( "PSA FINANCE ARGENTINA COMPAÑÍA FINANCIER", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "44099", httpContext.getMessage( "TOYOTA COMPAÑÍA FINANCIERA DE ARGENTINA", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "45030", httpContext.getMessage( "NARANJA DIGITAL COMPAÑÍA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "45056", httpContext.getMessage( "MONTEMAR COMPAÑIA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "45072", httpContext.getMessage( "TRANSATLANTICA COMPAÑIA FINANCIERA S.A.", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] = AV8banco_sdt ;
      new web.add_banco(remoteHandle, context).execute( "65203", httpContext.getMessage( "CREDITO REGIONAL COMPAÑIA FINANCIERA S.A", ""), GXv_objcol_Sdtbanco_sdt_banco_sdtItem1) ;
      AV8banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = ini_bancos.this.AV8banco_sdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8banco_sdt = new GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>(web.Sdtbanco_sdt_banco_sdtItem.class, "banco_sdtItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem1 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>[] aP0 ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> AV8banco_sdt ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> GXv_objcol_Sdtbanco_sdt_banco_sdtItem1[] ;
}

