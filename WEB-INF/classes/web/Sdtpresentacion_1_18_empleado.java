package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_empleado extends GxUserType
{
   public Sdtpresentacion_1_18_empleado( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_empleado.class));
   }

   public Sdtpresentacion_1_18_empleado( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_empleado");
   }

   public Sdtpresentacion_1_18_empleado( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_empleado");
   }

   public Sdtpresentacion_1_18_empleado( StructSdtpresentacion_1_18_empleado struct )
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
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "cuit") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_Cuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipoDoc") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_Tipodoc = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "apellido") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_Apellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nombre") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_Nombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "direccion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_empleado_Direccion == null )
               {
                  gxTv_Sdtpresentacion_1_18_empleado_Direccion = new web.Sdtpresentacion_1_18_empleado_direccion(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtpresentacion_1_18_empleado_Direccion.readxml(oReader, "direccion") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
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
         sName = "presentacion_1_18.empleado" ;
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
      oWriter.writeElement("cuit", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_Cuit, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("tipoDoc", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_Tipodoc, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("apellido", gxTv_Sdtpresentacion_1_18_empleado_Apellido);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nombre", gxTv_Sdtpresentacion_1_18_empleado_Nombre);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_empleado_Direccion != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_empleado_Direccion.writexml(oWriter, "direccion", sNameSpace1);
      }
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
      AddObjectProperty("cuit", gxTv_Sdtpresentacion_1_18_empleado_Cuit, false, false);
      AddObjectProperty("tipoDoc", gxTv_Sdtpresentacion_1_18_empleado_Tipodoc, false, false);
      AddObjectProperty("apellido", gxTv_Sdtpresentacion_1_18_empleado_Apellido, false, false);
      AddObjectProperty("nombre", gxTv_Sdtpresentacion_1_18_empleado_Nombre, false, false);
      if ( gxTv_Sdtpresentacion_1_18_empleado_Direccion != null )
      {
         AddObjectProperty("direccion", gxTv_Sdtpresentacion_1_18_empleado_Direccion, false, false);
      }
   }

   public long getgxTv_Sdtpresentacion_1_18_empleado_Cuit( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Cuit ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Cuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Cuit = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_Tipodoc( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Tipodoc ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Tipodoc( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Tipodoc = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_empleado_Apellido( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Apellido ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Apellido( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Apellido = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_empleado_Nombre( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Nombre ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Nombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Nombre = value ;
   }

   public web.Sdtpresentacion_1_18_empleado_direccion getgxTv_Sdtpresentacion_1_18_empleado_Direccion( )
   {
      if ( gxTv_Sdtpresentacion_1_18_empleado_Direccion == null )
      {
         gxTv_Sdtpresentacion_1_18_empleado_Direccion = new web.Sdtpresentacion_1_18_empleado_direccion(remoteHandle, context);
      }
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_empleado_Direccion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Direccion( web.Sdtpresentacion_1_18_empleado_direccion value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_Direccion = value;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_Direccion_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empleado_Direccion = (web.Sdtpresentacion_1_18_empleado_direccion)null;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_empleado_Direccion_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_empleado_Direccion == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_Direccion_N( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_Direccion_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_empleado_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empleado_Apellido = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_Direccion_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_N ;
   }

   public web.Sdtpresentacion_1_18_empleado Clone( )
   {
      return (web.Sdtpresentacion_1_18_empleado)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_empleado struct )
   {
      setgxTv_Sdtpresentacion_1_18_empleado_Cuit(struct.getCuit());
      setgxTv_Sdtpresentacion_1_18_empleado_Tipodoc(struct.getTipodoc());
      setgxTv_Sdtpresentacion_1_18_empleado_Apellido(struct.getApellido());
      setgxTv_Sdtpresentacion_1_18_empleado_Nombre(struct.getNombre());
      setgxTv_Sdtpresentacion_1_18_empleado_Direccion(new web.Sdtpresentacion_1_18_empleado_direccion(struct.getDireccion()));
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_empleado getStruct( )
   {
      web.StructSdtpresentacion_1_18_empleado struct = new web.StructSdtpresentacion_1_18_empleado ();
      struct.setCuit(getgxTv_Sdtpresentacion_1_18_empleado_Cuit());
      struct.setTipodoc(getgxTv_Sdtpresentacion_1_18_empleado_Tipodoc());
      struct.setApellido(getgxTv_Sdtpresentacion_1_18_empleado_Apellido());
      struct.setNombre(getgxTv_Sdtpresentacion_1_18_empleado_Nombre());
      struct.setDireccion(getgxTv_Sdtpresentacion_1_18_empleado_Direccion().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empleado_N ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_Tipodoc ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_Direccion_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_empleado_Cuit ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_Apellido ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_Nombre ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected web.Sdtpresentacion_1_18_empleado_direccion gxTv_Sdtpresentacion_1_18_empleado_Direccion=null ;
}

