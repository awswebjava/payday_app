package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConceptosAfipWizardData_Completado extends GxUserType
{
   public SdtConceptosAfipWizardData_Completado( )
   {
      this(  new ModelContext(SdtConceptosAfipWizardData_Completado.class));
   }

   public SdtConceptosAfipWizardData_Completado( ModelContext context )
   {
      super( context, "SdtConceptosAfipWizardData_Completado");
   }

   public SdtConceptosAfipWizardData_Completado( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtConceptosAfipWizardData_Completado");
   }

   public SdtConceptosAfipWizardData_Completado( StructSdtConceptosAfipWizardData_Completado struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ArchivoChar") )
            {
               gxTv_SdtConceptosAfipWizardData_Completado_Archivochar = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sdt_errores") )
            {
               if ( gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores == null )
               {
                  gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores = new GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem>(web.Sdtsdt_errores_sdt_erroresItem.class, "sdt_erroresItem", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores.readxml(oReader, "sdt_errores") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "sdt_errores") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "ConceptosAfipWizardData.Completado" ;
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
      oWriter.writeElement("ArchivoChar", gxTv_SdtConceptosAfipWizardData_Completado_Archivochar);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores.writexml(oWriter, "sdt_errores", sNameSpace1, sIncludeState);
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("ArchivoChar", gxTv_SdtConceptosAfipWizardData_Completado_Archivochar, false, false);
      if ( gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores != null )
      {
         AddObjectProperty("sdt_errores", gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores, false, false);
      }
   }

   public String getgxTv_SdtConceptosAfipWizardData_Completado_Archivochar( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_Archivochar ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Completado_Archivochar( String value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Archivochar = value ;
   }

   public GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> getgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores == null )
      {
         gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores = new GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem>(web.Sdtsdt_errores_sdt_erroresItem.class, "sdt_erroresItem", "PayDay", remoteHandle);
      }
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      return gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores( GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores = value ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_SetNull( )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores = null ;
   }

   public boolean getgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_IsNull( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_Archivochar = "" ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_N ;
   }

   public web.SdtConceptosAfipWizardData_Completado Clone( )
   {
      return (web.SdtConceptosAfipWizardData_Completado)(clone()) ;
   }

   public void setStruct( web.StructSdtConceptosAfipWizardData_Completado struct )
   {
      setgxTv_SdtConceptosAfipWizardData_Completado_Archivochar(struct.getArchivochar());
      GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux = new GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem>(web.Sdtsdt_errores_sdt_erroresItem.class, "sdt_erroresItem", "PayDay", remoteHandle);
      Vector<web.StructSdtsdt_errores_sdt_erroresItem> gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux1 = struct.getSdt_errores();
      if (gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux1.size(); i++)
         {
            gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux.add(new web.Sdtsdt_errores_sdt_erroresItem(gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores(gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConceptosAfipWizardData_Completado getStruct( )
   {
      web.StructSdtConceptosAfipWizardData_Completado struct = new web.StructSdtConceptosAfipWizardData_Completado ();
      struct.setArchivochar(getgxTv_SdtConceptosAfipWizardData_Completado_Archivochar());
      struct.setSdt_errores(getgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtConceptosAfipWizardData_Completado_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtConceptosAfipWizardData_Completado_Archivochar ;
   protected GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores_aux ;
   protected GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> gxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores=null ;
}

