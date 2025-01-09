package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_datoAdicional extends GxUserType
{
   public Sdtpresentacion_1_18_datoAdicional( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_datoAdicional.class));
   }

   public Sdtpresentacion_1_18_datoAdicional( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_datoAdicional");
   }

   public Sdtpresentacion_1_18_datoAdicional( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_datoAdicional");
   }

   public Sdtpresentacion_1_18_datoAdicional( StructSdtpresentacion_1_18_datoAdicional struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      if ( oReader.existsAttribute("nombre") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre = oReader.getAttributeByName("nombre") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("mesDesde") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde = (byte)(getnumericvalue(oReader.getAttributeByName("mesDesde"))) ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("mesHasta") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta = (byte)(getnumericvalue(oReader.getAttributeByName("mesHasta"))) ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("valor") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_datoAdicional_Valor = oReader.getAttributeByName("valor") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "presentacion_1_18.datoAdicional" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeAttribute("nombre", gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre);
      oWriter.writeAttribute("mesDesde", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde, 2, 0)));
      oWriter.writeAttribute("mesHasta", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta, 2, 0)));
      oWriter.writeAttribute("valor", gxTv_Sdtpresentacion_1_18_datoAdicional_Valor);
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("nombre", gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre, false, false);
      AddObjectProperty("mesDesde", gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde, false, false);
      AddObjectProperty("mesHasta", gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta, false, false);
      AddObjectProperty("valor", gxTv_Sdtpresentacion_1_18_datoAdicional_Valor, false, false);
   }

   public String getgxTv_Sdtpresentacion_1_18_datoAdicional_Nombre( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre ;
   }

   public void setgxTv_Sdtpresentacion_1_18_datoAdicional_Nombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde ;
   }

   public void setgxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde( byte value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta ;
   }

   public void setgxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta( byte value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_datoAdicional_Valor( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_Valor ;
   }

   public void setgxTv_Sdtpresentacion_1_18_datoAdicional_Valor( String value )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Valor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_datoAdicional_Valor = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_datoAdicional_N ;
   }

   public web.Sdtpresentacion_1_18_datoAdicional Clone( )
   {
      return (web.Sdtpresentacion_1_18_datoAdicional)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_datoAdicional struct )
   {
      setgxTv_Sdtpresentacion_1_18_datoAdicional_Nombre(struct.getNombre());
      setgxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde(struct.getMesdesde());
      setgxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta(struct.getMeshasta());
      setgxTv_Sdtpresentacion_1_18_datoAdicional_Valor(struct.getValor());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_datoAdicional getStruct( )
   {
      web.StructSdtpresentacion_1_18_datoAdicional struct = new web.StructSdtpresentacion_1_18_datoAdicional ();
      struct.setNombre(getgxTv_Sdtpresentacion_1_18_datoAdicional_Nombre());
      struct.setMesdesde(getgxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde());
      struct.setMeshasta(getgxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta());
      struct.setValor(getgxTv_Sdtpresentacion_1_18_datoAdicional_Valor());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_N ;
   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_Mesdesde ;
   protected byte gxTv_Sdtpresentacion_1_18_datoAdicional_Meshasta ;
   protected short readOk ;
   protected String gxTv_Sdtpresentacion_1_18_datoAdicional_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_datoAdicional_Valor ;
   protected boolean readElement ;
   protected boolean formatError ;
}

