package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_puesto_sdt_puestoItem extends GxUserType
{
   public Sdtsdt_puesto_sdt_puestoItem( )
   {
      this(  new ModelContext(Sdtsdt_puesto_sdt_puestoItem.class));
   }

   public Sdtsdt_puesto_sdt_puestoItem( ModelContext context )
   {
      super( context, "Sdtsdt_puesto_sdt_puestoItem");
   }

   public Sdtsdt_puesto_sdt_puestoItem( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_puesto_sdt_puestoItem");
   }

   public Sdtsdt_puesto_sdt_puestoItem( StructSdtsdt_puesto_sdt_puestoItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoCodigo") )
            {
               gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescrip") )
            {
               gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip = oReader.getValue() ;
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
         sName = "sdt_puesto.sdt_puestoItem" ;
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
      oWriter.writeElement("PuestoCodigo", gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoDescrip", gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip);
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
      AddObjectProperty("PuestoCodigo", gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo, false, false);
      AddObjectProperty("PuestoDescrip", gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip, false, false);
   }

   public String getgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo( )
   {
      return gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo ;
   }

   public void setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo( String value )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo = value ;
   }

   public String getgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip( )
   {
      return gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip ;
   }

   public void setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip( String value )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo = "" ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_N = (byte)(1) ;
      gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_puesto_sdt_puestoItem_N ;
   }

   public web.Sdtsdt_puesto_sdt_puestoItem Clone( )
   {
      return (web.Sdtsdt_puesto_sdt_puestoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_puesto_sdt_puestoItem struct )
   {
      setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo(struct.getPuestocodigo());
      setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip(struct.getPuestodescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_puesto_sdt_puestoItem getStruct( )
   {
      web.StructSdtsdt_puesto_sdt_puestoItem struct = new web.StructSdtsdt_puesto_sdt_puestoItem ();
      struct.setPuestocodigo(getgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo());
      struct.setPuestodescrip(getgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_puesto_sdt_puestoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip ;
}

