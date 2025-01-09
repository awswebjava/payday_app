package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_empleado_direccion extends GxUserType
{
   public Sdtpresentacion_1_18_empleado_direccion( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_empleado_direccion.class));
   }

   public Sdtpresentacion_1_18_empleado_direccion( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_empleado_direccion");
   }

   public Sdtpresentacion_1_18_empleado_direccion( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_empleado_direccion");
   }

   public Sdtpresentacion_1_18_empleado_direccion( StructSdtpresentacion_1_18_empleado_direccion struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "provincia") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cp") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "localidad") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "calle") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nro") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "piso") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "dpto") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "presentacion_1_18.empleado.direccion" ;
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
      oWriter.writeElement("provincia", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("cp", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("localidad", gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("calle", gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("nro", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("piso", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("dpto", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
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
      AddObjectProperty("provincia", gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia, false, false);
      AddObjectProperty("cp", gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp, false, false);
      AddObjectProperty("localidad", gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad, false, false);
      AddObjectProperty("calle", gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle, false, false);
      AddObjectProperty("nro", gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro, false, false);
      AddObjectProperty("piso", gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso, false, false);
      AddObjectProperty("dpto", gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto, false, false);
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia = value ;
   }

   public short getgxTv_Sdtpresentacion_1_18_empleado_direccion_Cp( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Cp( short value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_empleado_direccion_Calle( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Calle( String value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_direccion_Nro( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Nro( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_direccion_Piso( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Piso( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso = value ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto( byte value )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_empleado_direccion_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad = "" ;
      gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_empleado_direccion_N ;
   }

   public web.Sdtpresentacion_1_18_empleado_direccion Clone( )
   {
      return (web.Sdtpresentacion_1_18_empleado_direccion)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_empleado_direccion struct )
   {
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia(struct.getProvincia());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Cp(struct.getCp());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad(struct.getLocalidad());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Calle(struct.getCalle());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Nro(struct.getNro());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Piso(struct.getPiso());
      setgxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto(struct.getDpto());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_empleado_direccion getStruct( )
   {
      web.StructSdtpresentacion_1_18_empleado_direccion struct = new web.StructSdtpresentacion_1_18_empleado_direccion ();
      struct.setProvincia(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia());
      struct.setCp(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Cp());
      struct.setLocalidad(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad());
      struct.setCalle(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Calle());
      struct.setNro(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Nro());
      struct.setPiso(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Piso());
      struct.setDpto(getgxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Provincia ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_N ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Nro ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Piso ;
   protected byte gxTv_Sdtpresentacion_1_18_empleado_direccion_Dpto ;
   protected short gxTv_Sdtpresentacion_1_18_empleado_direccion_Cp ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_direccion_Localidad ;
   protected String gxTv_Sdtpresentacion_1_18_empleado_direccion_Calle ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

