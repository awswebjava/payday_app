package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_actividad_sdt_actividadItem extends GxUserType
{
   public Sdtsdt_actividad_sdt_actividadItem( )
   {
      this(  new ModelContext(Sdtsdt_actividad_sdt_actividadItem.class));
   }

   public Sdtsdt_actividad_sdt_actividadItem( ModelContext context )
   {
      super( context, "Sdtsdt_actividad_sdt_actividadItem");
   }

   public Sdtsdt_actividad_sdt_actividadItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_actividad_sdt_actividadItem");
   }

   public Sdtsdt_actividad_sdt_actividadItem( StructSdtsdt_actividad_sdt_actividadItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo") )
            {
               gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActDescrip") )
            {
               gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip = oReader.getValue() ;
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
         sName = "sdt_actividad.sdt_actividadItem" ;
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
      oWriter.writeElement("ActCodigo", gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActDescrip", gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("ActCodigo", gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo, false, false);
      AddObjectProperty("ActDescrip", gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip, false, false);
   }

   public String getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo( )
   {
      return gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo ;
   }

   public void setgxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo( String value )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_N = (byte)(0) ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo = value ;
   }

   public String getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip( )
   {
      return gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip ;
   }

   public void setgxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip( String value )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_N = (byte)(0) ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo = "" ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_N = (byte)(1) ;
      gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_actividad_sdt_actividadItem_N ;
   }

   public web.Sdtsdt_actividad_sdt_actividadItem Clone( )
   {
      return (web.Sdtsdt_actividad_sdt_actividadItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_actividad_sdt_actividadItem struct )
   {
      setgxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo(struct.getActcodigo());
      setgxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip(struct.getActdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_actividad_sdt_actividadItem getStruct( )
   {
      web.StructSdtsdt_actividad_sdt_actividadItem struct = new web.StructSdtsdt_actividad_sdt_actividadItem ();
      struct.setActcodigo(getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo());
      struct.setActdescrip(getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_actividad_sdt_actividadItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip ;
}

